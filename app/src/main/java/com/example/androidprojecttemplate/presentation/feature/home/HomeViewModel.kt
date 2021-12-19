package com.example.androidprojecttemplate.presentation.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidprojecttemplate.domain.core.*
import com.example.androidprojecttemplate.domain.entity.Repo
import com.example.androidprojecttemplate.domain.usecase.FindRepoByKeywordUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class HomeViewModel(private val findRepoByKeywordUseCase: FindRepoByKeywordUseCase) : ViewModel() {
    private val _queryFlow = MutableStateFlow<String>("")
    val query: StateFlow<String> = _queryFlow

    private val _queryResultFlow = MutableStateFlow<Result<List<Repo>>>(Result.Initial)
    val queryResultFlow: StateFlow<Result<List<Repo>>> = _queryResultFlow

    var job: Job? = null

    fun onQueryChange(query: String) {
        _queryFlow.value = query
    }

    fun search(query: String) {
        job?.cancel()
        if (query.isBlank()) {
            _queryResultFlow.value = Result.Initial
            return
        }

        job = viewModelScope.launch(Dispatchers.Default) {
            try {
                _queryResultFlow.value = Result.InProgress
                when (val result = findRepoByKeywordUseCase(query)) {
                    is Either.Left -> _queryResultFlow.value =
                        Result.Failure(error = result.left)
                    is Either.Right -> {
                        if (result.right.isEmpty()) {
                            _queryResultFlow.value = Result.Failure(error = DataNotFoundError())
                        } else {
                            _queryResultFlow.value = Result.Success(data = result.right)
                        }
                    }
                }
            } catch (e: CancellationException) {
                _queryResultFlow.value = Result.Initial
            }
        }
    }
}
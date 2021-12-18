package com.example.androidprojecttemplate.presentation.feature.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androidprojecttemplate.domain.core.Result
import com.example.androidprojecttemplate.domain.entity.Repo
import com.example.androidprojecttemplate.presentation.layout.*
import com.example.androidprojecttemplate.ui.theme.AndroidProjectTemplateTheme

@Composable
fun HomeScreenContent(modifier: Modifier, homeViewModel: HomeViewModel) {
    val query by homeViewModel.query.collectAsState()
    val queryResult by homeViewModel.queryResultFlow.collectAsState()

    Column(modifier = modifier.padding(all = 16.dp)) {
        Text(
            text = "Home",
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
        )
        HeightSpacer(height = 8.dp)
        RepoNameInputField(modifier = Modifier,
            text = query,
            onSearchClicked = { homeViewModel.search(query = query) },
            onTextChange = { value ->
                homeViewModel.onQueryChange(value)
            }
        )
        HeightSpacer(height = 8.dp)
        when (queryResult) {
            is Result.Failure ->
                CenteredText(
                    modifier = Modifier,
                    text = (queryResult as Result.Failure).error.message ?: ""
                )

            Result.InProgress -> ProgressIndicator(modifier = Modifier)

            Result.Initial -> CenteredText(
                modifier = Modifier,
                text = "Type keyword to find relevant repository"
            )

            is Result.Success -> RepoListView(
                modifier = Modifier,
                repoList = (queryResult as Result.Success<List<Repo>>).data
            )
        }

    }
}

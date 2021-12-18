package com.example.androidprojecttemplate.presentation.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.androidprojecttemplate.domain.entity.Repo

@Composable
fun RepoNameInputField(
    modifier: Modifier,
    text: String,
    onSearchClicked: () -> Unit,
    onTextChange: (value: String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = { onSearchClicked() }
        ),
        label = { Text(text = "Enter Query") },
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable {
                    onSearchClicked()
                },
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        },
        onValueChange = onTextChange
    )
}

@Composable
fun HeightSpacer(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun ProgressIndicator(modifier: Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
    }
}

@Composable
fun RepoListView(
    modifier: Modifier,
    repoList: List<Repo>
) {
    LazyColumn {
        items(repoList) { repo ->
            RepoListItem(modifier = modifier, repo = repo)
        }
    }
}

@Composable
fun CenteredText(modifier: Modifier, text: String) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(alignment = Alignment.Center),
            text = text
        )
    }
}

@Composable
fun RepoListItem(
    modifier: Modifier,
    repo: Repo
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {}
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(
                    data = repo.owner.avatar,
                    builder = {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(text = repo.name)
                Text(
                    text = repo.description ?: "",
                    maxLines = 2,
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}
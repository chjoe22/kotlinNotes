package com.example.exercise1.data.bars

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exercise1.data.viewmodel.TopBarViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(viewModel: TopBarViewModel = viewModel(), actions: @Composable RowScope.() -> Unit = {}){
    val title by viewModel.title
    TopAppBar(
        title = { Text(title) },
        actions = actions
//        navigationIcon = {
//            IconButton(onClick = {}) {
//                Icon(Icons.Filled.Menu, contentDescription = "Menu")
//            }
//        }
    )
}
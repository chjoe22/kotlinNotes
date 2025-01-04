package com.example.exercise1.data.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.exercise1.data.cards.FriendList
import com.example.exercise1.data.cards.ProfileCard
import com.example.exercise1.data.user.User
import com.example.exercise1.data.viewmodel.FriendListViewModel

@Composable
fun MainScreen(navController: NavController, user: User, listOfUsers: List<User>, viewModel: FriendListViewModel = viewModel()){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column {
            ProfileCard(user, Modifier.padding(innerPadding))

            LazyColumn {
                items(listOfUsers) { user ->
                    FriendList(user, navController, viewModel)
                }
            }
        }
    }
}
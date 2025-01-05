package com.example.exercise1.data.bars

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.exercise1.data.user.User

@Composable
fun BottomBar(navController: NavController, user: User){
    BottomAppBar (
        modifier = Modifier.fillMaxWidth().height(75.dp)
    ){
        IconButton(onClick = { navController.navigate("main") }) {
            Icon(Icons.Filled.Home, contentDescription = "Home")
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { navController.navigate("details/${user.firstName}/${user.lastName}/${user.age}/${user.image}") }) {
            Icon(Icons.Filled.AccountCircle, contentDescription = "Account")
        }
    }
}
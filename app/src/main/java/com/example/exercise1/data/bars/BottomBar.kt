package com.example.exercise1.data.bars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomBar(navController: NavController){
    BottomAppBar {
        IconButton(onClick = { navController.navigate("main") }) {
            Icon(Icons.Filled.Home, contentDescription = "Home")
        }
    }
}
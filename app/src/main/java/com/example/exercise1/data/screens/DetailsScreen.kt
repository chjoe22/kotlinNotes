package com.example.exercise1.data.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, firstName: String?, lastName: String?, age: Int?, image: Int?){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "return")
        }
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            image?.let { painterResource(id = it) }?.let {
                Image(
                    painter = it,
                    contentDescription = "Image",
                    modifier = Modifier.width(100.dp).height(100.dp).clip(RoundedCornerShape(50.dp))
                )
            }
            Text(text = "First Name: $firstName", style = MaterialTheme.typography.headlineLarge)
            Text(text = "Last Name: $lastName", style = MaterialTheme.typography.headlineLarge)
            Text(text = "Age: $age", style = MaterialTheme.typography.bodyMedium)
        }
    }

}
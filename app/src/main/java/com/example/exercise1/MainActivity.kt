package com.example.exercise1

import androidx.compose.foundation.Image;
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exercise1.data.bars.BottomBar
import com.example.exercise1.data.bars.TopBar
import com.example.exercise1.data.cards.FriendList
import com.example.exercise1.data.cards.ProfileCard
import com.example.exercise1.data.screens.DetailsScreen
import com.example.exercise1.data.screens.MainScreen
import com.example.exercise1.data.user.User
import com.example.exercise1.data.viewmodel.FriendListViewModel
import com.example.exercise1.data.viewmodel.TopBarViewModel
import com.example.exercise1.ui.theme.Exercise1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user = User("John", "Doe", 15, android.R.drawable.ic_menu_camera)
        val listOfUsers = listOf(
            User("Jane", "Doe", 15, R.drawable.baseline_person_24), User("Jane", "Doe", 15, R.drawable.baseline_person_24),
            User("Jane", "Doe", 15, R.drawable.baseline_person_24), User("Jane", "Doe", 15, R.drawable.baseline_person_24),
            User("Jane", "Doe", 15, R.drawable.baseline_person_24), User("Jane", "Doe", 15, R.drawable.baseline_person_24),
            User("Jane", "Doe", 15, R.drawable.baseline_person_24), User("Jane", "Doe", 15, R.drawable.baseline_person_24),
            User("Jane", "Doe", 15, R.drawable.baseline_person_24), User("Jane", "Doe", 15, R.drawable.baseline_person_24),
        )
        enableEdgeToEdge()
        setContent {
            val topBarViewModel: TopBarViewModel = viewModel()
            val friendListViewModel: FriendListViewModel = viewModel()
            Exercise1Theme (
                dynamicColor = false
            ) {
                val navController = rememberNavController()
                Scaffold (
                    topBar = { TopBar(viewModel = topBarViewModel) },
                    bottomBar = { BottomBar(navController) }
                ){ paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = "main",
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable("main"){
                            MainScreen(navController, user, listOfUsers, friendListViewModel, topBarViewModel)
                        }
                        composable("details/{firstName}/{lastName}/{age}/{image}"){ backStackEntry ->
                            val firstName = backStackEntry.arguments?.getString("firstName")
                            val lastName = backStackEntry.arguments?.getString("lastName")
                            val age = backStackEntry.arguments?.getString("age")?.toInt()
                            val image = backStackEntry.arguments?.getString("image")?.toInt()
                            DetailsScreen(navController, firstName, lastName, age, image, topBarViewModel = topBarViewModel)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Exercise1Theme {
        ProfileCard(user = User("John", "Doe", 15, android.R.drawable.ic_menu_camera))
    }
}
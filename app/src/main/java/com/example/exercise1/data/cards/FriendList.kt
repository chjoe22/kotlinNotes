package com.example.exercise1.data.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.exercise1.R
import com.example.exercise1.data.user.User
import com.example.exercise1.data.viewmodel.FriendListViewModel

@Composable
fun FriendList(user: User, navController: NavController, viewModel: FriendListViewModel = viewModel()) {
    val userId = user.getId()
    val isGreen = viewModel.toggledButtons.contains(userId)
    val backgroundColor = if (isGreen) Color.Green else Color.Unspecified
    Card(
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        modifier = Modifier.fillMaxSize().padding(16.dp).clickable {
            navController.navigate("details/${user.firstName}/${user.lastName}/${user.age}/${user.image}")
        }
    ){
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = user.image),
                contentDescription = "Profile Picture",
                modifier = Modifier.width(100.dp).height(100.dp).clip(RoundedCornerShape(50.dp))
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = user.firstName + " " + user.lastName,
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "Age: " + user.age,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Button(
                onClick = {
                    viewModel.toggleButton(userId)
                },
                modifier = Modifier.padding(8.dp).size(50.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonColors(
                    contentColor = Color.Transparent,
                    containerColor = Color.Unspecified,
                    disabledContentColor = Color.LightGray,
                    disabledContainerColor = Color.LightGray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_add_24),
                    contentDescription = "Add Friend",
                )
            }
        }
    }
}
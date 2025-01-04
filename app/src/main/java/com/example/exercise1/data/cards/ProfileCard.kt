package com.example.exercise1.data.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.exercise1.data.user.User

@Composable
fun ProfileCard(user: User, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.padding(16.dp).fillMaxWidth(),
    ) {
        Row(modifier = modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = user.image),
                contentDescription = "Profile Picture",
                modifier = modifier.size(64.dp).clip(RoundedCornerShape(32.dp))
            )
            Spacer(modifier = modifier.width(16.dp))
            Column {
                Text(text = user.firstName + " " + user.lastName, style = MaterialTheme.typography.headlineLarge)
                Text(text = "Age: " + user.age, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
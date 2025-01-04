package com.example.exercise1.data.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel

class FriendListViewModel : ViewModel() {
    val cardColors: SnapshotStateMap<String, Boolean> = mutableStateMapOf()
    fun toggleCardColor(userId: String){
        cardColors[userId] = cardColors[userId] != true
    }

    var toggledButtons by mutableStateOf(setOf<String>())
        private set
    fun toggleButton(userId: String){
        toggledButtons = if (toggledButtons.contains(userId))
            toggledButtons - userId
        else
            toggledButtons + userId
    }
}
package com.example.exercise1.data.viewmodel

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel

class FriendListViewModel : ViewModel() {
    val cardColors: SnapshotStateMap<String, Boolean> = mutableStateMapOf()
    fun toggleCardColor(userId: String){
        cardColors[userId] = cardColors[userId] != true
    }
}
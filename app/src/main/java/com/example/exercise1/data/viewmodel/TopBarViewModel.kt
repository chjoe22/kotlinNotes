package com.example.exercise1.data.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TopBarViewModel : ViewModel(){
    private val _title = mutableStateOf("Top Bar")
    val title: State<String> = _title
    fun setTitle(newTitle: String){
        _title.value = newTitle
    }
}
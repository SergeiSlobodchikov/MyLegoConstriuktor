package com.example.assembletheconstructoryourself

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class MainViewModelFactory(private val legoPartsDao: LegoPartsDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(legoPartsDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
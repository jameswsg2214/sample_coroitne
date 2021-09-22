package com.example.androidlearning

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidlearning.Network.ApiInterface
import com.example.androidlearning.Room.AppDatabase
import com.example.androidlearning.repo.LiveDataRepo

class LiveDataViewModelFactory(private val apiHelper: ApiInterface, val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LiveDataViewModel::class.java)) {
            return LiveDataViewModel(LiveDataRepo(apiHelper, AppDatabase(context)),context) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}

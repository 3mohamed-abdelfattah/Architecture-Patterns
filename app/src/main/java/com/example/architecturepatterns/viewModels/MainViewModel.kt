package com.example.architecturepatterns.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecturepatterns.model.User
import com.example.architecturepatterns.model.wisdom
import com.example.architecturepatterns.repository.RepositoryMain


//---------------------------------------------MVVM---------------------------------------------
class MainViewModel : ViewModel() {

    private val repository = RepositoryMain()

    // MutableLiveData Streaming of data (Don't lose data while rotating screen)
    val currentUser = MutableLiveData<User>()
    val wisdom = MutableLiveData<wisdom>()

    //To Get User Use Repository Pattern
    fun fetchUser() {
        currentUser.postValue(repository.getCurrentUser())
    }

    //To Get Wisdom Use Repository Pattern
    fun getWisdom() {
        wisdom.postValue(repository.getRandomWisdom())
    }
}
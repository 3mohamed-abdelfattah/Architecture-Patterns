package com.example.architecturepatterns.presenter

import com.example.architecturepatterns.FakeApiServes
import com.example.architecturepatterns.FakeDatabase
import com.example.architecturepatterns.repository.RepositoryMain
import com.example.architecturepatterns.ui.IMainView

class MainPresenter {

    //To Get data Use Presenter
//    private val api = FakeApiServes()
//    private val fakeData = FakeDatabase()
    lateinit var view: IMainView

    //To Get data Repository Pattern
    private val repository = RepositoryMain()


    //To Get User Use Repository Pattern
    fun fetchUser() {
        val result = repository.getCurrentUser()
        view.onUserInfoSuccess(result)
    }

    //To Get Wisdom Use Repository Pattern
    fun getWisdom() {
        val result = repository.getRandomWisdom()
        view.onWisdomSuccess(result)
    }

//    //To Get User Use Presenter
//    fun fetchUser() {
//        val result = fakeData.getCurrentUser()
//        view.onUserInfoSuccess(result)
//    }
//
//    //To Get Wisdom Use Presenter
//    fun getWisdom() {
//        val result = api.getWisdomRandom()
//        view.onWisdomSuccess(result)
//    }


}
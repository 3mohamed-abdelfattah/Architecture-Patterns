package com.example.architecturepatterns.presenter

import com.example.architecturepatterns.FakeApiServes
import com.example.architecturepatterns.FakeDatabase
import com.example.architecturepatterns.ui.IMainView

class MainPresenter {

    private val api = FakeApiServes()
    private val fakeData = FakeDatabase()
    lateinit var view: IMainView

    //To Get User
    fun fetchUser() {
        val result = fakeData.getCurrentUser()
        view.onUserInfoSuccess(result)
    }

    //To Get Wisdom
    fun getWisdom() {
        val result = api.getWisdomRandom()
        view.onWisdomSuccess(result)
    }


}
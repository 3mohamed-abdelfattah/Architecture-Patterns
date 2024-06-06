package com.example.architecturepatterns.repository

import com.example.architecturepatterns.FakeApiServes
import com.example.architecturepatterns.FakeDatabase

class RepositoryMain {
    private val api = FakeApiServes()
    private val fakeData = FakeDatabase()

    fun getCurrentUser() = fakeData.getCurrentUser()
    fun getRandomWisdom() = api.getWisdomRandom()
}
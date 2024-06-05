package com.example.architecturepatterns

import com.example.architecturepatterns.model.User

class FakeDatabase() {
    fun getCurrentUser(): User {
        return User("Mohamed Mohamed", 2002)
    }
}
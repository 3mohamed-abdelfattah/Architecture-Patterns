package com.example.architecturepatterns.ui

import com.example.architecturepatterns.model.User
import com.example.architecturepatterns.model.wisdom

interface IMainView {
    fun onUserInfoSuccess(user: User)
    fun onWisdomSuccess(wisdom: wisdom)
}
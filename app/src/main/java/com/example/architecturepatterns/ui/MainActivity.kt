package com.example.architecturepatterns.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.architecturepatterns.FakeApiServes
import com.example.architecturepatterns.FakeDatabase
import com.example.architecturepatterns.R
import com.example.architecturepatterns.databinding.ActivityMainBinding
import com.example.architecturepatterns.model.User
import com.example.architecturepatterns.model.wisdom
import com.example.architecturepatterns.presenter.MainPresenter
import com.example.architecturepatterns.viewModels.MainViewModel

class MainActivity : AppCompatActivity(), IMainView {
    lateinit var binding: ActivityMainBinding

    //For MVP
    private val presenter = MainPresenter()

    //For MVVM
    private val viewModel: MainViewModel by viewModels()


    //For MVC
    val api = FakeApiServes()
    val fakeData = FakeDatabase()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //MVC
//        fetchUser()
//        setup()
        setupMVVM()
    }

    fun fetchWisdom(view: View) {
        val result = api.getWisdomRandom()
        binding.apply {
            date.text = result.publisherDate
            content.text = result.content
        }
    }

    //MVC
    fun fetchUser() {
        val result = fakeData.getCurrentUser()
        binding.userName.text = result.name
    }


    //For MVP Setup
    private fun setup() {
        presenter.view = this
        presenter.fetchUser()
        binding.fetchButton.setOnClickListener {
            presenter.getWisdom()
        }
    }


    //For MVVM Setup
    private fun setupMVVM() {
        viewModel.fetchUser()
        binding.fetchButton.setOnClickListener {
            viewModel.getWisdom()
        }

        viewModel.currentUser.observe(this) {
            binding.userName.text = it.name
        }

        viewModel.wisdom.observe(this) {
            binding.apply {
                date.text = it.publisherDate
                content.text = it.content
            }
        }

    }

    //MVP To Get User
    override fun onUserInfoSuccess(user: User) {
        binding.userName.text = user.name
    }

    //MVP To Get Content
    override fun onWisdomSuccess(wisdom: wisdom) {
        binding.apply {
            date.text = wisdom.publisherDate
            content.text = wisdom.content
        }
    }

}
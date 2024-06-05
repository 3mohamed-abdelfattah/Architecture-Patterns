package com.example.architecturepatterns

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.architecturepatterns.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val api = FakeApiServes()
    val fakeData = FakeDatabase()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fetchUser()
    }

    fun fetchWisdom(view: View) {
        val result = api.getWisdomRandom()
        binding.apply {
            date.text = result.publisherDate
            content.text = result.content
        }
    }

    fun fetchUser() {
        val result = fakeData.getCurrentUser()
        binding.userName.text = result.name
    }
}
package com.example.acadia.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.acadia.R
import com.example.acadia.databinding.ActivityMainBinding
import android.content.Intent
import com.example.acadia.databinding.ActivityLoginBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
        val intent=Intent(this@MainActivity,SignUp::class.java)
            startActivity(intent)
            finish()
    }}
}
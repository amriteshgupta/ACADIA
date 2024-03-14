package com.example.acadia.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.acadia.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
        }

        binding.textViewForgotPassword.setOnClickListener {

        }
    }
}

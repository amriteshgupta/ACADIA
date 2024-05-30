package com.example.pl

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pl.databinding.ActivityMainBinding
import com.example.pl.databinding.ActivityStartBinding
import com.google.firebase.database.FirebaseDatabase

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.register.setOnClickListener {
            val intent= Intent(this, Register::class.java)
            startActivity(intent)
            finish()
        }
        binding.login.setOnClickListener {
            val intent= Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }


    }
}
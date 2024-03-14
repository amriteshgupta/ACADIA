package com.example.acadia.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.acadia.R

class Splash : AppCompatActivity() {
    val SPLASH_DELAY: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this@Splash, Login::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }
}
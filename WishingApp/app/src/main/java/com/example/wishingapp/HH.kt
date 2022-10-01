package com.example.wishingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HH : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hh)
        var tx: TextView = findViewById(R.id.tx)
        val value= intent.getStringExtra("name")
        tx.setText("Happy Holi "+value)
    }
}
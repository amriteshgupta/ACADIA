package com.example.wishingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HNY : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hny)
        var tx: TextView = findViewById(R.id.tx)
        val value= intent.getStringExtra("name")
        tx.setText("Happy New Year "+value)
    }
}
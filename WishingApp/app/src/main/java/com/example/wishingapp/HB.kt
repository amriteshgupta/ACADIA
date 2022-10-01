package com.example.wishingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hb)
        var tx: TextView= findViewById(R.id.tx)
        val value= intent.getStringExtra("name")
        tx.setText("Happy Birthday "+value)
    }
}
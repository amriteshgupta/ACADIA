package com.amritesh.avengers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var toolbar: Toolbar =findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
}
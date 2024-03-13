package com.amritesh.plc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Avengers_Login : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers_login)

        var etEmail:EditText=findViewById(R.id.etEmail)
        var etPass:EditText=findViewById(R.id.etPass)
        var btLogIn:Button=findViewById(R.id.btLogIn)

        btLogIn.setOnClickListener {
           Intent(this,Avengers::class.java).also {
               startActivity(it)
           }
        }


    }
}
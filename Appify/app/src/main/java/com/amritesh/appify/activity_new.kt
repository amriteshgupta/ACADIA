package com.amritesh.appify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class activity_new : AppCompatActivity() , View.OnClickListener{




    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        title= "Login"

        etMobileNumber=findViewById(R.id.etPassword)
        etPassword = findViewById(R.id.etPassword)
        btnLogin= findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)

        btnLogin.setOnClickListener(this)


    }
    override fun onClick(p0: View?) {
        Toast.makeText(
            this@activity_new,
            "We clicked on the button to see this Toast!",
            Toast.LENGTH_LONG
        ).show()
    }

}
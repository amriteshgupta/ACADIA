package com.amritesh.campusconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var imgLogo:ImageView= findViewById(R.id.imgLogo)
        var etEmail:EditText=findViewById(R.id.etEmail)
        var etPassword:EditText=findViewById(R.id.etPassword)
        var btnLogin:Button=findViewById(R.id.btnLogin)

        val intent= Intent(this,MainActivity::class.java)
       val email= etEmail.text.toString().trim();
        val password=etPassword.text.toString().trim();
        val validEmail="admin@cc.com"
        val validPassword="password"
        btnLogin.setOnClickListener{
            if (email==validEmail && password==validPassword){
                Toast.makeText(this, "Email Required", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(intent)
                finish()
            }

        }

    }
}
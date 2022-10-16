package com.internship.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NewActivity : AppCompatActivity() {


    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val vaildMobileNumber = "0123456789"
    val validPassword = arrayOf("tony", "steve", "bruce", "thanos")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        title = "Log In"
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.password)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)



        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()

            val password = etPassword.text.toString()

            var nameOfAvenger = "Avenger"

            val intent = Intent(this@NewActivity, MainActivity::class.java)

            if ((mobileNumber == vaildMobileNumber)) {

                if (password == validPassword[0]) {

                    nameOfAvenger = "Iron Man"
                    startActivity(intent)
                    intent.putExtra("Name",nameOfAvenger)

                } else if (password == validPassword[1]) {
                    nameOfAvenger = "Captain America"
                    startActivity(intent)
                    intent.putExtra("Name",nameOfAvenger)
                } else if (password == validPassword[2]) {
                    nameOfAvenger = "The Hulk"
                    startActivity(intent)
                    intent.putExtra("Name",nameOfAvenger)
                } else if (password == validPassword[3]) {
                    nameOfAvenger = "The Avengers"
                    startActivity(intent)
                    intent.putExtra("Name",nameOfAvenger)
                }

            } else {
                Toast.makeText(this@NewActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()
            }


        }

    }
}



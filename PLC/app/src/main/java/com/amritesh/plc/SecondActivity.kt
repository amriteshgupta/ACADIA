package com.amritesh.plc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var backBT: Button = findViewById(R.id.backBt)
        var person=intent.getSerializableExtra("ExtraPerson") as Person
//        var name= intent.getStringExtra("ExtraName")
//        var age= intent.getIntExtra("ExtraAge",0)
//        var gender= intent.getStringExtra("ExtraGender")
        var tv2:TextView=findViewById(R.id.tv2)
//        var person="$name is $gender and is $age years old"
//        tv2.text=person
        tv2.text=person.toString()

        backBT.setOnClickListener {

        Intent(this, MainActivity::class.java).also {
            startActivity(it)
        }

    }
    }
}
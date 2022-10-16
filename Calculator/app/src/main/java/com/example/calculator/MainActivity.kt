package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var et_Value1: EditText=findViewById(R.id.et_Value1)
        var et_Value2: EditText= findViewById(R.id.et_Value2)
        var txt_Output: TextView = findViewById(R.id.txt_Output)
        var bt_Plus: Button= findViewById(R.id.bt_Plus)
        var bt_Minus: Button= findViewById(R.id.bt_Minus)

        
        val content1: String=et_Value1.getText().toString()
        val content2: String= et_Value2.getText().toString()

        bt_Plus.setOnClickListener(){
            txt_Output.setText(content1+content2)
        }
    }
}


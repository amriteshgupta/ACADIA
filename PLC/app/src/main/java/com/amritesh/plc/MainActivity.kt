package com.amritesh.plc

import android.R.layout
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

//    val iv_user:ImageView=findViewById(R.id.iv_user)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val layoutInflater = LayoutInflater.from(this)
//        val view: View = layoutInflater.inflate(R.layout.custom_toast,null)



        var btn1: Button = findViewById(R.id.btn1)
        val etName:EditText=findViewById(R.id.etName)
        val etAge:EditText=findViewById(R.id.etAge)
        val etGender:EditText=findViewById(R.id.etGender)
        val btn_User:Button=findViewById(R.id.btn_User)
//        val iv_user:ImageView=findViewById(R.id.iv_user)


        btn_User.setOnClickListener{
            Intent(Intent.ACTION_GET_CONTENT).also{
                it.type="image/*"
                startActivityForResult(it,0)
            }
        }


        btn1.setOnClickListener {


            var name=etName.text.toString()
            var age= etAge.text.toString().toInt()
            var gender=etGender.text.toString()
            var person=Person(name, age, gender)


            Intent(this,SecondActivity::class.java).also {


                it.putExtra("ExtraPerson",person)
//                it.putExtra("ExtraName",name)
//                it.putExtra("ExtraAge",age)
//                it.putExtra("ExtraGender",gender)

                startActivity(it)
            }

            //            Toast(this).apply {
//                duration = Toast.LENGTH_LONG
//                view = layoutInflater.inflate(R.layout.custom_toast, null)}

//            val toast = Toast(this)
//            toast.duration = Toast.LENGTH_SHORT
//            toast.view = view
//            toast.show()

        }
    }


override fun onActivityResult(requestCode: Int, resultCode:Int, data:Intent?){
    super.onActivityResult(resultCode,resultCode,data)


    if(resultCode== Activity.RESULT_OK && requestCode==0){
        val uri = data?.data
        iv_user.setImageURI(uri)
    }
}}
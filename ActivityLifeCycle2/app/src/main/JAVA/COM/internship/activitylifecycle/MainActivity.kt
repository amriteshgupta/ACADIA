package com.internship.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var titleName:String? = "Avengers"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scrollview)

        if(intent != null)
            titleName =intent.getStringExtra("Name")
        title = titleName
    }

//    override fun onStart() {
//        super.onStart()
//        println("OnStart called")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        println("OnResume called")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        println("onPause called")
//
//    }
//
//    override fun onStop() {
//        super.onStop()
//        println("onStop called")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        println("onDestroy")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        println("OnRestart")
//    }
}
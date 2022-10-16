package com.example.wishingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishsomeone.CustomAdapter
import com.example.wishsomeone.ItemsViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recylcerView= findViewById<RecyclerView>(R.id.recyclerView)
        var et:EditText= findViewById(R.id.et)

        recylcerView.layoutManager=LinearLayoutManager(this)

        val data = ArrayList<ItemsViewModel>()

        data.add(ItemsViewModel(R.drawable.birthday, "Happy Birthday"))
        data.add(ItemsViewModel(R.drawable.diwali, "HappyDiwali"))
        data.add(ItemsViewModel(R.drawable.happynewyear, "Happy New Year"))
        data.add(ItemsViewModel(R.drawable.holi, "Happy Holi"))
        data.add(ItemsViewModel(R.drawable.batman,"Happy Batman Day"))

        val adapter= CustomAdapter(data,et)

        recylcerView.adapter= adapter
    }
}
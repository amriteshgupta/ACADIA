package com.example.todolist

import TaskAdapter
import android.os.Bundle
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity(),UpdateAndDelete {


lateinit var database: DatabaseReference
    private lateinit var binding: ActivityMainBinding
    var toDoList = mutableListOf<TodoModel>()
    lateinit var adapter: TaskAdapter
    private var listViewItem: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        listViewItem = binding.recyclerViewTasks as ListView
        database = FirebaseDatabase.getInstance().reference

        binding.fabAddTask.setOnClickListener {
            showAddTaskDialog()
        }
        toDoList = mutableListOf<TodoModel>()
        adapter= TaskAdapter(this, toDoList)
        listViewItem!!.adapter = adapter
        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                toDoList.clear()
                snapshot.children.forEach{
                    val todoItemData = it.getValue(TodoModel::class.java)
                    toDoList.add(todoItemData!!)
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "No Data", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun showAddTaskDialog() {
        val alertDialog = AlertDialog.Builder(this)
        val textEditText = EditText(this)
        alertDialog.setView(textEditText)
        alertDialog.setMessage("Enter a task")
        alertDialog.setTitle("Add a new task")
        alertDialog.setPositiveButton("Submit") { dialog, i ->
//            val task = textEditText.text.toString()
//            val id = tasks.size + 1
//            val newTask = Task(id, task, false)
//            tasks.add(newTask)
//            adapter.notifyDataSetChanged()
//            database.child("tasks").child(id.toString()).setValue(newTask)

            val todoItemData = TodoModel.create()
            todoItemData.itemDataText = textEditText.text.toString()
            todoItemData.done = false

            val newItemData = database.child("todo").push()
            todoItemData.UID = newItemData.key

            newItemData.setValue(todoItemData)

            dialog.dismiss()
            Toast.makeText(this, "Task added", Toast.LENGTH_SHORT).show()

        }
        alertDialog.show()
    }
    override fun modifyItem(itemUID: String, isDone: Boolean) {
        val itemReference = database.child("todo").child(itemUID)
        itemReference.child("done").setValue(isDone)
    }

    override fun onItemDelete(itemUID: String) {
        val itemReference = database.child("todo").child(itemUID)
        itemReference.removeValue()
        adapter.notifyDataSetChanged()
    }
}


package com.example.todolist

interface UpdateAndDelete {

    fun modifyItem(itemUID: String, isDone: Boolean)
    fun onItemDelete(itemUID: String)
}
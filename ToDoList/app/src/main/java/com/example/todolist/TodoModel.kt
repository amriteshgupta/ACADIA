package com.example.todolist

class TodoModel {

    companion object Factory{
        fun create(): TodoModel = TodoModel()
    }
    var UID:String?= null
    var itemDataText:String?=null
    var done:Boolean? = false
}
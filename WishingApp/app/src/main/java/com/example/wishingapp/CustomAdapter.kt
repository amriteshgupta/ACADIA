package com.example.wishsomeone


import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.wishingapp.*


class CustomAdapter(private val mList: List<ItemsViewModel>,var et:EditText) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text
        holder.itemView.setOnClickListener {
            var value= et.text.toString()

            it.setOnClickListener {
                if(position==0){
                    val context: Context = holder.itemView.context
                    val myactivity = Intent(context.getApplicationContext(), HB::class.java)
                    myactivity.putExtra("name", value)
                    myactivity.addFlags(FLAG_ACTIVITY_NEW_TASK)
                    context.getApplicationContext().startActivity(myactivity)
                }
                if(position==1){
                    val context: Context = holder.itemView.context
                    val myactivity = Intent(context.getApplicationContext(), HD::class.java)
                    myactivity.putExtra("name", value)
                    myactivity.addFlags(FLAG_ACTIVITY_NEW_TASK)
                    context.getApplicationContext().startActivity(myactivity)
                }
                if(position==2){
                    val context: Context = holder.itemView.context
                    val myactivity = Intent(context.getApplicationContext(), HNY::class.java)
                    myactivity.putExtra("name", value)
                    myactivity.addFlags(FLAG_ACTIVITY_NEW_TASK)
                    context.getApplicationContext().startActivity(myactivity)
                }
                if(position==3){
                    val context: Context = holder.itemView.context
                    val myactivity = Intent(context.getApplicationContext(), HH::class.java)
                    myactivity.putExtra("name", value)
                    myactivity.addFlags(FLAG_ACTIVITY_NEW_TASK)
                    context.getApplicationContext().startActivity(myactivity)
                }
                if(position==4){
                    val context: Context = holder.itemView.context
                    val myactivity = Intent(context.getApplicationContext(), HBD::class.java)
                    myactivity.putExtra("name", value)
                    myactivity.addFlags(FLAG_ACTIVITY_NEW_TASK)
                    context.getApplicationContext().startActivity(myactivity)
                }

            }
        } // click event

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}
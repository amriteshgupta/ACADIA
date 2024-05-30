package com.example.pl

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pl.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth=FirebaseAuth.getInstance()

        binding.btnLogOut.setOnClickListener {
            auth.signOut()
            Toast.makeText(this, "User logged out successfully", Toast.LENGTH_SHORT).show()
            var intent= Intent(this, StartActivity::class.java)
            startActivity(intent)
            finish()
        }

        FirebaseDatabase.getInstance().reference.child("PTDB").child("users").setValue("Anshul")

        FirebaseDatabase.getInstance().reference.child("Language")


//            (auth.currentUser?.uid.toString()).get().addOnSuccessListener {
//            binding.tvWelcome.text="Welcome, ${it.child("name").value.toString()}"
//        }.addOnFailureListener {
//            Toast.makeText(this, "Failed to fetch user data", Toast.LENGTH_SHORT).show()
//        }
        var map=HashMap<String, Any>()
        map["name"] = "Anshul"
        map["email"] = "Anshul@gmail.com"


        FirebaseDatabase.getInstance().getReference().child("PTDB").child("MultipleValues").updateChildren(map)

        binding.button.setOnClickListener{
            var name=binding.etName.text.toString()
            if(name.isEmpty()){
                Toast.makeText(this, "Please enter Language's name", Toast.LENGTH_SHORT).show()
}else{
                FirebaseDatabase.getInstance().getReference().child("Language").child("name").setValue(name).addOnSuccessListener {
                    Toast.makeText(this, "Name updated successfully", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed to update name", Toast.LENGTH_SHORT).show()
                }
            }
        }
    var list = arrayListOf<String>()
    var adapter = ArrayAdapter(this,R.layout.list_item, list)
        binding.listView.adapter=adapter

        var reference: DatabaseReference =FirebaseDatabase.getInstance().getReference().child("Information")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                for (data in snapshot.children){
                    var info:Information=data.getValue(Information::class.java)!!
                    var txt= "${info.email} : ${info.name}"
                    list.add(txt)
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Failed to fetch data", Toast.LENGTH_SHORT).show()
            }

        })

    }
}
package com.example.pl

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pl.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

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

//            (auth.currentUser?.uid.toString()).get().addOnSuccessListener {
//            binding.tvWelcome.text="Welcome, ${it.child("name").value.toString()}"
//        }.addOnFailureListener {
//            Toast.makeText(this, "Failed to fetch user data", Toast.LENGTH_SHORT).show()
//        }
        var map=HashMap<String, Any>()
        map.put("name", "Anshul")
        map.put("email", "Anshul@gmail.com")


        FirebaseDatabase.getInstance().getReference().child("PTDB").child("MultipleValues").updateChildren(map)



    }
}
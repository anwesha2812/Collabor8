package com.example.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.app1.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val password = binding.edtPassword.text.toString()
            val moodle = binding.edtMoodleId.text.toString()

            if(moodle.isNotEmpty()){
                database=FirebaseDatabase.getInstance().getReference("Users")
                database.child(moodle).get().addOnSuccessListener {
                    if(it.exists()){
                        val pw=it.child("password").value
                        if (pw != null) {
                            if(pw == password){
                                if(moodle=="A1000000"){
                                    val intent = Intent(this, AdminHomepage::class.java)
                                    startActivity(intent)
                                }else {
                                    val intent = Intent(this, MyProjects::class.java)
                                    startActivity(intent)
                                }
                            }else{
                                Toast.makeText(this,"Incorrect Password", Toast.LENGTH_SHORT).show()
                            }
                        }else{
                            Toast.makeText(this,"Please Enter Password", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this, "Could not log in",Toast.LENGTH_SHORT).show()
                    }
                }.addOnFailureListener(){
                    Toast.makeText(this,"Account does not exist. Sign Up", Toast.LENGTH_SHORT).show()
                }
            } else{
                Toast.makeText(this, "Please enter Moodle ID",Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

    }


}


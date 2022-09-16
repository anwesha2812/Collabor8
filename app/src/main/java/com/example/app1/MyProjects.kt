package com.example.app1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app1.databinding.StudentHomepageBinding
import com.google.firebase.database.DatabaseReference

class MyProjects : AppCompatActivity() {
    private lateinit var binding : StudentHomepageBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.student_homepage)
        binding = StudentHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)


            binding.textView.setOnClickListener{
                val intent = Intent(this, DisplayProjectDetails::class.java)
                startActivity(intent)

            }
    }
}
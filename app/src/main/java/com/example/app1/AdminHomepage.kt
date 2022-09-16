package com.example.app1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app1.databinding.AdminHomepageBinding


class AdminHomepage : AppCompatActivity(){
    private lateinit var binding : AdminHomepageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AdminHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener(){
            val intent = Intent(this, CreateGroup::class.java)
            startActivity(intent)
        }
        binding.button2.setOnClickListener(){
            val intent = Intent(this, ViewGroups::class.java)
            startActivity(intent)
        }

    }
}
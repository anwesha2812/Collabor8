package com.example.app1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.app1.databinding.DivisionListBinding

class DivisionList : AppCompatActivity() {
    private lateinit var binding: DivisionListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DivisionListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvCreateGroup.setOnClickListener() {
            val intent = Intent(this, DivisionList::class.java)
            startActivity(intent)
        }
    }
}
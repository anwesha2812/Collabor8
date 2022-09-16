package com.example.app1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


import com.example.app1.databinding.ViewGroupsBinding

class ViewGroups: AppCompatActivity() {
    private lateinit var binding : ViewGroupsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewGroupsBinding.inflate(layoutInflater)
        setContentView(binding.root)

}

}
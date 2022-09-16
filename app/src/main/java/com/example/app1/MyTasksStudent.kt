package com.example.app1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app1.databinding.MyTasksStudentBinding

class MyTasksStudent : AppCompatActivity() {

    private lateinit var binding: MyTasksStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MyTasksStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTasks.setOnClickListener() {

        }
    }
}
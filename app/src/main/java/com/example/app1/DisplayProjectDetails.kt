package com.example.app1

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.app1.databinding.ActivityMainBinding
import com.example.app1.databinding.ActivitySignupBinding
import com.example.app1.databinding.DisplayProjectDetailsBinding
import com.example.app1.databinding.MyTasksStudentBinding
import com.google.android.material.navigation.NavigationView

class DisplayProjectDetails : AppCompatActivity(){

    private lateinit var binding : DisplayProjectDetailsBinding
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.display_project_details)
        binding = DisplayProjectDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val navDrawer =

        binding.apply {
            toggle = ActionBarDrawerToggle(this@DisplayProjectDetails, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()
        }


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.ndProjectDetails.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miItem1 -> {
                    val intent = Intent(this, MyTasksStudent::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

//     fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(toggle.onOptionsItemSelected(item)) {
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }


 }
    }
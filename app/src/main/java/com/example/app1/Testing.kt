package com.example.app1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app1.databinding.TestingBinding
import com.google.android.material.textfield.TextInputLayout


class Testing :  AppCompatActivity(){
//    private lateinit var binding: TestingBinding
    private lateinit var dep : String
    val dept = arrayOf("Comps","IT","Civil", "Mech", "EXTC", "AIML", "DS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = TestingBinding.inflate(layoutInflater)
        setContentView(R.layout.testing)
//        binding.btnRegister.setOnClickListener() {
//            val spinner = binding.spDept
//            val arrayAdapter =
//                ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dept)
//            spinner.adapter = arrayAdapter
//            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                     dep = dept[p2]
//                }
//
//                override fun onNothingSelected(p0: AdapterView<*>?) {
//                    Toast.makeText(this@Testing, "Select dept", Toast.LENGTH_SHORT).show()
//                }
//            }
//            Toast.makeText(this@Testing, dep, Toast.LENGTH_SHORT).show()
//        }
        val spinner1: Spinner = findViewById(R.id.spDept)
        val spinner2: Spinner = findViewById(R.id.spYear)
        val spinner3: Spinner = findViewById(R.id.spDiv)
        val spContBranch:TextInputLayout=findViewById(R.id.spinContBranch)
        val spContYear:TextInputLayout=findViewById(R.id.spinContYear)
        val spContDiv:TextInputLayout=findViewById(R.id.spinContDiv)

        ArrayAdapter.createFromResource(this, R.array.dep_array, android.R.layout.simple_spinner_item
        ).also {
                adapter1 ->
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter=adapter1

        }

        ArrayAdapter.createFromResource(this, R.array.year_array, android.R.layout.simple_spinner_item
        ).also {
                adapter2 ->
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter=adapter2

        }

        ArrayAdapter.createFromResource(this, R.array.div_array, android.R.layout.simple_spinner_item
        ).also {
                adapter3 ->
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner3.adapter=adapter3

        }

        spinner1.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               dep= p0?.getItemAtPosition(p2).toString()
                //spContBranch.helperText= myoption
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        spContBranch.helperText= dep
        spinner2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val myoption = p0?.getItemAtPosition(p2).toString()
                spContBranch.helperText = myoption
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        spinner3.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val myoption = p0?.getItemAtPosition(p2).toString()
                spContBranch.helperText = myoption
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}
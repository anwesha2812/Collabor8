package com.example.app1
import android.content.Intent
import android.os.Bundle
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import com.example.app1.databinding.ActivitySignupBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    var x=0
    var y=0
    var z=0
    var h=0
    private lateinit var binding: ActivitySignupBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegister.isEnabled=false
        emailFocusListener()
        passwordFocusListener()
        phoneFocusListener()


        //retype logic
        binding.etRepassword.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                val pw= binding.etPassword.text.toString()
                val pw2= binding.etRepassword.text.toString()

                if(pw!=pw2){
                    h=1
                    binding.tilRepassword.helperText ="Passwords don't match"
                }else{
                    h=0
                    binding.tilRepassword.helperText ="Passwords match"
                }
            }
        })

        if (x==0 && y==0 && z==0 && h==0){
            binding.btnRegister.isEnabled=true
        }else{
            Toast.makeText(this, "Check whether all field are valid", Toast.LENGTH_SHORT).show()
        }

        binding.btnRegister.setOnClickListener {
            val name = binding.etFullname.text.toString()
            val moodle = binding.etMoodle.text.toString()
            val department = binding.etDept.text.toString()
            val year = binding.etYear.text.toString()
            val div = binding.etDivision.text.toString()
            val phone = binding.etPhone.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()



            database = FirebaseDatabase.getInstance().getReference("Users")
            val user = User(name, moodle, department, year, div, phone, email, password)
            database.child(moodle).get().addOnSuccessListener {
                if(it.exists()){
                    Toast.makeText(this, "Account Exists, Login to continue", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }

            database.child(moodle).setValue(user).addOnSuccessListener {

                binding.etFullname.text?.clear()
                binding.etMoodle.text?.clear()
                binding.etDept.text?.clear()
                binding.etYear.text?.clear()
                binding.etPhone.text?.clear()
                binding.etDivision.text?.clear()
                binding.etEmail.text?.clear()
                binding.etPassword.text?.clear()
                binding.etRepassword.text?.clear()

                Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
            }

        }

    }
    private fun emailFocusListener()
    {
        binding.etEmail.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.tilEmail.helperText = validEmail()
            }
        }
    }
    private fun validEmail(): String?
    {
        val emailText = binding.etEmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            x=1
            return "Invalid Email Address"
        }
        else{
            x=0
            return ""
        }
    }
    private fun passwordFocusListener()
    {
        binding.etPassword.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.tilPassword.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String?
    {
        val passwordText = binding.etPassword.text.toString()
        if(passwordText.length < 8)
        {
            y=1
            return "Minimum 8 Character Password"
        }
        else if(!passwordText.matches(".*[A-Z].*".toRegex()))
        {
            y=1
            return "Must Contain 1 Upper-case Character"
        }
        else if(!passwordText.matches(".*[a-z].*".toRegex()))
        {
            y=1
            return "Must Contain 1 Lower-case Character"
        }
        else if(!passwordText.matches(".*[@#\$%^&+=].*".toRegex()))
        {
            y=1
            return "Must Contain 1 Special Character (@#\$%^&+=)"
        }
        else{
            y=0
            return ""
        }
    }
    private fun phoneFocusListener()
    {
        binding.etPhone.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.tilPhone.helperText = validPhone()
            }
        }
    }

    private fun validPhone(): String?
    {
        val phoneText = binding.etPhone.text.toString()
        if(!phoneText.matches(".*[0-9].*".toRegex()))
        {
            z=1
            return "Must be all Digits"
        }
        else if(phoneText.length != 10)
        {
            z=1
            return "Must be 10 Digits"
        }else{
            z=0
            return ""
        }
    }
//    private fun retypePasswordValidator(){
//        binding.etRepassword.setOnFocusChangeListener { _, focused ->
//            if(!focused)
//            {
//                binding.tilRepassword.helperText = validRePassword()
//
//                }
//            }
//        if(validRePassword()=="Passwords match"){
//            binding.btnRegister.isEnabled=true
//        }
//    }
//    private fun validRePassword():String{
//        val pw= binding.etPassword.text.toString()
//        val pw2= binding.etRepassword.text.toString()
//
//        return if(pw!=pw2){
//            "Passwords don't match"
//            // binding.btnRegister.isEnabled=false
//        }else{
//            "Passwords match"
//
//        }
//    }



}

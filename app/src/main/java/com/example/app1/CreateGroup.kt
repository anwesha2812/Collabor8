package com.example.app1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app1.databinding.CreateGroupBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CreateGroup : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var binding: CreateGroupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CreateGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var dept: String = "IT"
        var year: String = "BE"
        var div: String = "C"
//
//        binding.rgDept.setOnCheckedChangeListener{ group, checkedID ->
//            if(checkedID==binding.rbComps){
//                dept = "Comps"}
//            if(checkedID==binding.rbIT){
//                dept = "IT"}
//            if(checkedID==binding.rbCivil){
//                dept = "Civil"}
//            if(checkedID==binding.rbMech){
//                dept = "Mech"}
//            if(checkedID==binding.rbAIML){
//                dept = "AIML"}
//            if(checkedID==binding.rbDS){
//                dept = "DS"}
//        }
//        binding.rgYear.setOnCheckedChangeListener{ group, checkedID ->
//            if(checkedID==binding.rbSE){
//                year = "SE"}
//            if(checkedID==binding.rbTE){
//                year = "TE"}
//            if(checkedID==binding.rbBE){
//                year = "BE"}
//
//        }
//
//        binding.rgDiv.setOnCheckedChangeListener{ group, checkedID ->
//            if(checkedID==binding.rbA){
//                div = "SE"}
//            if(checkedID==binding.rbB){
//                div = "TE"}
//            if(checkedID==binding.rbC){
//                div = "BE"}
//
//        }
        binding.tvBranch.text="IT"
        binding.tvYear.text="BE"
        binding.tvDivision.text="C"

        binding.btnCreate.setOnClickListener() {
//i need - branch, div, year from CREATEgROUP PAGE...
// dynamically calculate the number of children under branch->year->div


            val path ="Groups/"+dept+"/"+year+"/"+div
            val m1mid = binding.edtMID1.text.toString()
            val m2mid = binding.edtMID2.text.toString()
            val m3mid = binding.edtMID3.text.toString()
            val m4mid = binding.edtMID4.text.toString()
            val gfid = binding.edtGID.text.toString()
            val groupID = dept+year+div+m1mid


            database = FirebaseDatabase.getInstance().getReference(path)
            val group = GroupDataClass(groupID,m1mid,m2mid,m3mid,m4mid,gfid)
            database.child(groupID).setValue(group).addOnSuccessListener{
                Toast.makeText(this@CreateGroup,"Group Created Successfully",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener(){
                Toast.makeText(this@CreateGroup,"Something went wrong",Toast.LENGTH_SHORT).show()
            }
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(m1mid).child("GroupID").setValue(groupID)
            database.child(m1mid).child("Role").setValue("Leader")
            database.child(m2mid).child("GroupID").setValue(groupID)
            database.child(m2mid).child("Role").setValue("Member")
            database.child(m3mid).child("GroupID").setValue(groupID)
            database.child(m3mid).child("Role").setValue("Member")
            database.child(m4mid).child("GroupID").setValue(groupID)
            database.child(m4mid).child("Role").setValue("Member")
        }
    }
}
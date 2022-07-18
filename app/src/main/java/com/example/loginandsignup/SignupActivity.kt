package com.example.loginandsignup

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.loginandsignup.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("info", MODE_PRIVATE)

        binding.slogin.setOnClickListener(View.OnClickListener {
            editor = sharedPreferences.edit()
            if (binding.name.text.isEmpty()) {
                binding.name.setError("Field Can not be emplt")
            }
            else if (binding.semail.text.isEmpty()) {
                binding.semail.setError("Field Can not be emplt")
            }
            else if (binding.spass.text.isEmpty()) {
                binding.spass.setError("Field Can not be emplt")
            }
            else if (binding.gender.text.isEmpty()) {
                binding.gender.setError("Field Can not be emplt")
            }
            else if (binding.hobby.text.isEmpty()) {
                binding.hobby.setError("Field Can not be emplt")
            }
            else{

                if(binding.name.text.toString().trim().isNotEmpty()){
                    editor.putString("name",binding.name.text.toString().trim())
                }

                if(binding.semail.text.toString().trim().isNotEmpty()){
                    editor.putString("email",binding.semail.text.toString().trim())
                }

                if(binding.spass.text.toString().trim().isNotEmpty()){
                    editor.putString("pass",binding.spass.text.toString().trim())
                }

                if(binding.gender.text.toString().trim().isNotEmpty()){
                    editor.putString("gender",binding.gender.text.toString().trim())
                }
                if(binding.hobby.text.toString().trim().isNotEmpty()){
                    editor.putString("hobby",binding.hobby.text.toString().trim())
                }
                editor.commit()
                var intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }
        })
    }
}
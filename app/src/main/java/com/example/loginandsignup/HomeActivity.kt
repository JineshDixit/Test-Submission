package com.example.loginandsignup

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.loginandsignup.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("info", MODE_PRIVATE)

        binding.logou.setOnClickListener(View.OnClickListener {
            editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            finish()

            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)

        })

        binding.name.setText("Name: ${sharedPreferences.getString("name","")}")
        binding.email.setText("Email: ${sharedPreferences.getString("email","")}")
        binding.pass.setText("Password: ${sharedPreferences.getString("pass","")}")
        binding.gender.setText("Gender: ${sharedPreferences.getString("gender","")}")
        binding.hobby.setText("Hobby: ${sharedPreferences.getString("hobby","")}")

    }
}
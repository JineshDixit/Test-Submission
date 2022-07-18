package com.example.loginandsignup

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginandsignup.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    var email : String = ""
    var pass : String = ""
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("info", MODE_PRIVATE)

        var loginCheck : Boolean = sharedPreferences.getBoolean("FirstLogin", false);

        if (loginCheck) {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.login.setOnClickListener(View.OnClickListener {
            editor = sharedPreferences.edit()
            email = binding.email.text.toString().trim()
            pass = binding.pass.text.toString().trim()
            var usermail = sharedPreferences.getString("email","")
            var userpass = sharedPreferences.getString("pass","")

            if(email == usermail){
                if(pass == userpass){
                    editor.putBoolean("FirstLogin", true)
                    editor.commit()
                    var intent = Intent(this,HomeActivity::class.java)
                    startActivity(intent)

                }
                else{
                    val toast = Toast.makeText(applicationContext, "Value is incorrect", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
            else{
                val toast = Toast.makeText(applicationContext, "Value is incorrect", Toast.LENGTH_SHORT)
                toast.show()
            }

        })

        binding.signin.setOnClickListener(View.OnClickListener {

            var intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)

        })

    }
}
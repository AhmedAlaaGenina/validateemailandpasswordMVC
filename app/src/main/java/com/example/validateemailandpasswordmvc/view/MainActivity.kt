package com.example.validateemailandpasswordmvc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.validateemailandpasswordmvc.R
import com.example.validateemailandpasswordmvc.controler.Controler
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var password: EditText = edtPassword
        var email: EditText = edtEmail
        val emailPattern = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        btnLogin.setOnClickListener {
            if (Controler.validateEmail(
                    email.text.toString(),
                    password.text.toString(),
                    emailPattern
                )
            ) {
                Toast.makeText(
                    applicationContext, "Valid email and password",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext, "Invalid email and password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


}
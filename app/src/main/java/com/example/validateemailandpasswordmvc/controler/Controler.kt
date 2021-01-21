package com.example.validateemailandpasswordmvc.controler

import android.widget.Toast
import java.util.regex.Pattern

class Controler {

    companion object {
        fun validateEmail(email: String, password: String, emailPattern: Pattern): Boolean {
            return emailPattern.matcher(email).matches() && password.isNotEmpty()
        }
    }
}

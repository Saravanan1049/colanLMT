package com.example.colanlmt.view.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.colanlmt.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_login, LoginFragment())
            .addToBackStack(null)
            .commit()
    }
}
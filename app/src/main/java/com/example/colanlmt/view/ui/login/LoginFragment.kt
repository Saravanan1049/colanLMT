package com.example.colanlmt.view.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.colanlmt.R
import com.example.colanlmt.view.ui.home.HomeActivity

class LoginFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val loginView = inflater.inflate(R.layout.fragment_login, container, false)

        val forgotPassword:TextView=loginView.findViewById(R.id.forgotPassword)
        forgotPassword.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_login, ForgotPasswordFragment())
                .addToBackStack(null)
                .commit()
        }

        val btn_login:AppCompatButton=loginView.findViewById(R.id.btn_login)
        btn_login.setOnClickListener {
            startActivity(Intent(context, HomeActivity::class.java))
        }

        return  loginView
    }


}
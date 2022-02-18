package com.example.colanlmt.view.ui.login

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.colanlmt.R

class ForgotPasswordFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val forgotView = inflater.inflate(R.layout.fragment_forgot_password, container, false)

        val spanText: TextView =forgotView.findViewById(R.id.back_to_login)
        val spannable = SpannableString("Back to Sign In")
        spannable.setSpan(ForegroundColorSpan(Color.BLUE),8,15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spanText.setText(spannable)
        spanText.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_login, LoginFragment())
                .commit()
        }



        return forgotView
    }


}
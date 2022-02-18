package com.example.colanlmt.view.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.colanlmt.R
import com.example.colanlmt.databinding.FragmentForgotPasswordBinding
import com.example.colanlmt.databinding.FragmentPasswordChangeBinding

class PasswordChangeFragment : Fragment() {

    var _binding:FragmentPasswordChangeBinding?=null
    val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentPasswordChangeBinding.inflate(inflater, container, false)




        return binding?.root
    }


}
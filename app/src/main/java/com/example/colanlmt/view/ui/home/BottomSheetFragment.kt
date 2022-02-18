package com.example.colanlmt.view.ui.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.colanlmt.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)

        view.setBackgroundResource(R.drawable.bottom_sheet_background)

        return view
    }

    override fun getTheme(): Int {
        return R.style.NoBackgroundDialogTheme
    }

    companion object{
        val TAG="Modal Bottom Sheet"
    }

}
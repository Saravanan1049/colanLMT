package com.example.colanlmt.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.colanlmt.R


class SignOutFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.sign_out, container, false)

        return view
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val view: View = layoutInflater.inflate(R.layout.chooser_bottom_sheet, null)
//        val dialog = BottomSheetDialog(this, R.style.BottomSheetDialog) // Style here
//
//        dialog.setContentView(view)
//        dialog.show()
//    }
}
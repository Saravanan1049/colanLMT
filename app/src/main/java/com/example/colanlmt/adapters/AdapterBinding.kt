package com.example.colanlmt.ui.home

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.colanlmt.R
import com.example.colanlmt.utils.Status


@BindingAdapter("status")
fun binding(view: TextView, status: String){
    view.text=status
    when(status){
        Status.approved->{

            view.setTextColor(ContextCompat.getColor(view.context, R.color.approved))
            view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.approvedBg))

        }
        Status.pending->{

            view.setTextColor(ContextCompat.getColor(view.context, R.color.pending))
            view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.pendingBg))

        }
        Status.rejected->{

            view.setTextColor(ContextCompat.getColor(view.context, R.color.rejected))
            view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.rejectedBg))
        }


    }

}
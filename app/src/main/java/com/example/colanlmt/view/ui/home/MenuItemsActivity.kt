package com.example.colanlmt.view.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.colanlmt.R
import com.example.colanlmt.databinding.ActivityOfMenuitemsBinding
import java.util.*

class MenuItemsActivity : AppCompatActivity() {
    lateinit var binding: ActivityOfMenuitemsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOfMenuitemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val position = intent.getIntExtra("value",0)
         Log.d("menuActivityCheck", "$position")

        when(position){
            0 -> {
                Log.d("menuActivityCheck", "$position")
                supportFragmentManager.beginTransaction().replace(R.id.container,ProfileFragment()).commit()
            }
            1-> supportFragmentManager.beginTransaction().replace(R.id.container,PasswordChangeFragment()).commit()
            2 -> supportFragmentManager.beginTransaction().replace(R.id.container,AboutUsFragment()).commit()
            3-> supportFragmentManager.beginTransaction().replace(R.id.container,SignOutFragment()).commit()
        }
    }





}
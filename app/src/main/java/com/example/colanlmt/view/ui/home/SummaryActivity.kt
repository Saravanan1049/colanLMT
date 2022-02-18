package com.example.colanlmt.view.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import com.example.colanlmt.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)





        val bottomNav:BottomNavigationView=findViewById(R.id.bottom_navigation)
        val fragmentSummary:FragmentContainerView=findViewById(R.id.fragment_summary)
        bottomNav.menu.findItem(R.id.summary).setChecked(true)
        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.summary->{
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_summary, SummaryFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.my_request->{
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_summary, MyRequestFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.home->{
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                else -> {false}
            }


        }
    }
}
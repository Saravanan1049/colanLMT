package com.example.colanlmt.view.ui.home

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import com.example.colanlmt.R
import com.example.colanlmt.databinding.HomeLayoutBinding
import com.example.colanlmt.model.DrawerMenu
import java.util.*



class HomeActivity : AppCompatActivity() {
    lateinit var binding: HomeLayoutBinding
    val menudataList = ArrayList<DrawerMenu>()

lateinit var slidingRootNav : SlidingRootNav
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.home_layout)

        window.statusBarColor = ResourcesCompat.getColor(resources, R.color.lmtblue, null)
        binding.toolBarHome.title = "Home"
        actionBar?.title = ""

//        slidingRootNav = SlidingRootNavBuilder(this)
//            .withToolbarMenuToggle(binding.toolBarHome)
//            .withMenuOpened(false)
//            .withContentClickableWhenMenuOpened(true)
//            .withSavedState(savedInstanceState)
//            .withMenuLayout(R.layout.drawer_menu_layout)
//            .inject()
        binding.toolBarHome.navigationIcon =
            ResourcesCompat.getDrawable(getResources(), R.drawable.ic_menu, null)
//        val closeicon = findViewById<ImageView>(R.id.closeIcon)
//        closeicon.setOnClickListener {
//            slidingRootNav.closeMenu()
    }
}























//        val btnSummary:Button=findViewById(R.id.btn_summary)
//        val myRequest:Button=findViewById(R.id.btn_my_request)
//        val compOff:Button=findViewById(R.id.btn_comp_off)
//        val leavePolicy:Button=findViewById(R.id.btn_leave_policy)
//        val changePassword:Button=findViewById(R.id.btn_change)
//        val fragment:FragmentContainerView=findViewById(R.id.fragment)

//        btnSummary.setOnClickListener{
//            startActivity(Intent(this, SummaryActivity::class.java))
//        }
//        changePassword.setOnClickListener {
//            btnSummary.visibility=View.GONE
//            myRequest.visibility=View.GONE
//            compOff.visibility=View.GONE
//            leavePolicy.visibility=View.GONE
//            changePassword.visibility=View.GONE
//
//            fragment.visibility=View.VISIBLE
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragment,PasswordChangeFragment())
//                .addToBackStack(null)
//                .commit()
//        }


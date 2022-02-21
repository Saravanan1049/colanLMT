package com.example.colanlmt.view.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colanlmt.R
import com.example.colanlmt.adapters.ClickInterface
import com.example.colanlmt.adapters.MenuAdaper
import com.example.colanlmt.databinding.HomeLayoutBinding
import com.example.colanlmt.model.DrawerMenu
import com.yarolegovich.slidingrootnav.SlidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder
import java.util.*



class HomeActivity : AppCompatActivity(),ClickInterface {
    lateinit var binding: HomeLayoutBinding
    val menudataList = ArrayList<DrawerMenu>()

    lateinit var slidingRootNav: SlidingRootNav
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.home_layout)

        window.statusBarColor = ResourcesCompat.getColor(resources, R.color.lmtblue, null)
        binding.toolBarHome.title = "Home"
        actionBar?.title = ""

        slidingRootNav = SlidingRootNavBuilder(this)
            .withToolbarMenuToggle(binding.toolBarHome)
            .withMenuOpened(false)
            .withContentClickableWhenMenuOpened(true)
            .withSavedState(savedInstanceState)
            .withMenuLayout(R.layout.drawer_menu_layout)
            .inject()
        binding.toolBarHome.navigationIcon =
            ResourcesCompat.getDrawable(resources, R.drawable.ic_menu, null)
        val closeIcon = findViewById<ImageView>(R.id.closeIcon)
        closeIcon.setOnClickListener {
            slidingRootNav.closeMenu()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.menuList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MenuAdaper(setMenuData(), this, this)


    }
    fun setMenuData(): List<DrawerMenu> {
        menudataList.add(DrawerMenu(R.drawable.profile_icon, "Profile"))
        menudataList.add(DrawerMenu(R.drawable.changepassword_icon, "Change Password"))
        menudataList.add(DrawerMenu(R.drawable.aboutus_icon, "About us"))
        menudataList.add(DrawerMenu(R.drawable.signout_icon, "Sign out"))
        return menudataList
    }


    override fun click(i: Int) {
        val intent = Intent(this, MenuItemsActivity::class.java)
        intent.putExtra("value", i)
        startActivity(intent)
    }


    fun setcolor(id: View, color: Int) {
        id.backgroundTintList = ContextCompat.getColorStateList(this, color)
//        val d : GradientDrawable = id.background as GradientDrawable
//        d.mutate()
//        d.setColor(ContextCompat.getColor(applicationContext,color))
//        d.

//        val unwrappeddrawable : Drawable =  id.background
//        val wrappeddrawable : Drawable = DrawableCompat.wrap(unwrappeddrawable)
//        DrawableCompat.setTint(wrappeddrawable,color)set
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


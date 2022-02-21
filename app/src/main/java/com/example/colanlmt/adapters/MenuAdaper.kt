package com.example.colanlmt.adapters//package com.example.lmt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.colanlmt.R
import com.example.colanlmt.model.DrawerMenu
import com.example.colanlmt.view.ui.MainActivity

class MenuAdaper(val list: List<DrawerMenu>, val context: Context, val click : ClickInterface) : RecyclerView.Adapter<MenuAdaper.MyViewHolder>() {

  val main = MainActivity()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.drawer_menu_card,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val data = list[position]
        holder.text.text = data.menu
        holder.image.setImageResource(data.image)
        holder.itemView.setOnClickListener {
         click.click(position)
        }
    }

    override fun getItemCount() = list.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val  text = itemView.findViewById<TextView>(R.id.title)
        val  image = itemView.findViewById<ImageView>(R.id.image)


    }

}
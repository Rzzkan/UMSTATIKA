package com.rzzkan.dicoding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rzzkan.umstatika.R
import com.rzzkan.umstatika.model.Menu

class MenuAdapterVertical (private val menuList:ArrayList<Menu>): RecyclerView.Adapter<MenuAdapterVertical.viewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class viewHolder(view:View):RecyclerView.ViewHolder(view){
        var ivImage:ImageView = view.findViewById(R.id.ivImage)
        var tvTitle:TextView = view.findViewById(R.id.tvTitle)
        var tvDesc:TextView = view.findViewById(R.id.tvDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_vertical, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val (image, title, desc) = menuList[position]
        holder.tvTitle.setText(title)
        holder.tvDesc.setText(desc)
        Glide.with(holder.itemView.context).load(image).into(holder.ivImage)
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(menuList[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = menuList.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Menu)
    }


}
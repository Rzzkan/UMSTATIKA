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

class MenuAdapterHorizontal (private val menuList:ArrayList<Menu>): RecyclerView.Adapter<MenuAdapterHorizontal.viewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class viewHolder(view:View):RecyclerView.ViewHolder(view){
        var ivImage:ImageView = view.findViewById(R.id.ivImage)
        var tvTitle:TextView = view.findViewById(R.id.tvTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_hroizontal, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val (image, title, desc) = menuList[position]
        holder.tvTitle.setText(title)
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
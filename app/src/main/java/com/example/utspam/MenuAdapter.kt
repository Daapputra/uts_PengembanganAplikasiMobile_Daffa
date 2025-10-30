package com.example.utspam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val data: List<MenuItem>) : RecyclerView.Adapter<MenuAdapter.VH>() {

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_menu_name)
        val tvDesc: TextView = view.findViewById(R.id.tv_menu_desc)
        val tvPrice: TextView = view.findViewById(R.id.tv_menu_price)
        val chk: CheckBox = view.findViewById(R.id.chk_menu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = data[position]
        holder.tvName.text = item.name
        holder.tvDesc.text = item.description
        holder.tvPrice.text = "Rp ${item.price}"
        holder.chk.isChecked = item.isSelected

        holder.chk.setOnCheckedChangeListener { _, isChecked ->
            item.isSelected = isChecked
        }

        holder.itemView.setOnClickListener {
            val newState = !holder.chk.isChecked
            holder.chk.isChecked = newState
            item.isSelected = newState
        }
    }

    override fun getItemCount(): Int = data.size

    fun getSelectedItems(): List<MenuItem> {
        return data.filter { it.isSelected }
    }
}

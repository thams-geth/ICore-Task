package com.tts.icore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_favoutite.view.*

class FavouriteAdapter(var list: List<String>, var listener: ClickListener) :
    RecyclerView.Adapter<FavouriteAdapter.ViewHolder>() {

    var set: HashSet<String> = HashSet()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteAdapter.ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_favoutite, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FavouriteAdapter.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {

            if (holder.itemView.txt.isSelected) {
                holder.itemView.txt.isSelected = false
                set.remove(holder.itemView.txt.text.toString())
            } else {
                holder.itemView.txt.isSelected = true
                set.add(holder.itemView.txt.text.toString())
            }
            listener.selectedItem(set)
//            holder.itemView.txt.isSelected = !holder.itemView.txt.isSelected
        }
        holder.itemView.txt.text = list[position]
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    interface ClickListener {
        fun selectedItem(item: HashSet<String>)


    }
}
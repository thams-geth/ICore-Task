package com.tts.icore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_productlist.view.*

class ProductListAdapter(var list: List<Product>, var context: Context) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    var set: HashSet<String> = HashSet()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListAdapter.ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_productlist, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductListAdapter.ViewHolder, position: Int) {

        holder.itemView.txtTitle.text = list[position].title
        holder.itemView.txtDetails.text = list[position].details
        holder.itemView.txtDetails.visibility = View.GONE
        holder.itemView.imageView.isSelected = false

        holder.itemView.imageView.setOnClickListener {
            if (holder.itemView.imageView.isSelected) {
                holder.itemView.imageView.isSelected = false
                holder.itemView.imageView.background = ContextCompat.getDrawable(context, R.drawable.ic_baseline_keyboard_arrow_down_24)
                holder.itemView.txtDetails.visibility = View.GONE

            } else {
                holder.itemView.imageView.isSelected = true
                holder.itemView.imageView.background = ContextCompat.getDrawable(context, R.drawable.ic_baseline_keyboard_arrow_up_24)
                holder.itemView.txtDetails.visibility = View.VISIBLE


            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}
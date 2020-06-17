package com.example.picasso

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ItemAdapter (
    var items : List<ItemOfList>
) : RecyclerView.Adapter<ItemAdapter.MainHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private val itemImage = itemView.findViewById<ImageView>(R.id.ImageView)

        fun bind(item : ItemOfList)
        {
            Picasso.get()
                .load(item.imageSrc)
                .fit()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(itemImage)
        }

    }
}


package com.mantismink.anbuquizbeta

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StoreAdapter (data:ArrayList<StoreClass> , var context:Context) : RecyclerView.Adapter<StoreAdapter.ViewHolder> () {


    var data:List<StoreClass>

    init {
        this.data = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val layout = LayoutInflater.from(context).inflate(R.layout.itemcustom , parent , false)

        return ViewHolder(layout)
    }
    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.image.setImageResource(data[position].image)
    }
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

       var title:TextView
       var image:ImageView


        init {

            title = itemView.findViewById(R.id.storeTitle)
            image = itemView.findViewById(R.id.storeImage)
        }
    }
}
package com.mantismink.anbuquizbeta

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(data:ArrayList<PostClass>, var context:Context) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {



    var data:List<PostClass>

    init {
        this.data = data
    }


    class ViewHolder(item:View) : RecyclerView.ViewHolder(item) {

        var postTitle:TextView
        var postImage:ImageView
        var post:TextView

        init {
            postTitle = item.findViewById(R.id.titlepost)
            postImage = item.findViewById(R.id.imageposts)
            post = item.findViewById(R.id.postdisplay)
        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postTitle.text = data[position].title
        holder.postImage.setImageResource(data[position].image)
        holder.post.text = data[position].post
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.postview , parent , false)

        return ViewHolder(layout)
    }
    override fun getItemCount(): Int {
        return data.size
    }
}
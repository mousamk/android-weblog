package com.parinaz.weblog.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.parinaz.weblog.Post
import com.parinaz.weblog.R
import com.parinaz.weblog.databinding.ListItemBinding

class PostAdapter(private val context: Context, private val dataset: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val postViewHolder = PostViewHolder(view)
       return postViewHolder
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = dataset[position]
        holder.binding.postTitle.text = post.title
        holder.binding.postBody.text = post.body
        //body
        //...
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ListItemBinding.bind(itemView)

    }
}
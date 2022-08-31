package com.parinaz.weblog.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.parinaz.weblog.MainActivity
import com.parinaz.weblog.Post
import com.parinaz.weblog.R
import com.parinaz.weblog.databinding.ListItemBinding

class PostAdapter(
    private val context: Context,
    private val dataset: List<Post>,
    private val clickListener: MainActivity.OnPostClickListener
    ) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val postViewHolder = PostViewHolder(view, clickListener)
       return postViewHolder
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = dataset[position]
        holder.binding.postTitle.text = post.title
        holder.binding.postBody.text = post.body
        holder.post = dataset[position]
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    class PostViewHolder(itemView: View, val clickListener: MainActivity.OnPostClickListener) : RecyclerView.ViewHolder(itemView){
        val binding = ListItemBinding.bind(itemView)
        lateinit var post: Post

        init {
            binding.root.setOnClickListener {
                clickListener.onClick(post)
            }

        }
    }
}

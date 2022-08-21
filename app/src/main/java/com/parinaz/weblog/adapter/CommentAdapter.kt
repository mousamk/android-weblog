package com.parinaz.weblog.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.parinaz.weblog.Comment
import com.parinaz.weblog.R
import com.parinaz.weblog.databinding.CommentItemBinding
import com.parinaz.weblog.databinding.ListItemBinding

class CommentAdapter (private val context: Context,
                      private val dataset : List<Comment>) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.comment_item, parent, false)
        return CommentViewHolder (view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = dataset[position]
        holder.binding.commentText.text = comment.body
        holder.binding.commentName.text = comment.name
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    class CommentViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val binding = CommentItemBinding.bind(itemView)
        lateinit var comment: Comment
    }
}
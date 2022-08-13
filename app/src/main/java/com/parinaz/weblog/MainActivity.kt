package com.parinaz.weblog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.parinaz.weblog.adapter.PostAdapter
import com.parinaz.weblog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.recyclerView
        val postRepository = PostRepository()


        val postClickListener = object: OnPostClickListener {
            override fun onClick(post: Post){
                val intent = Intent(this@MainActivity, PostIndividualActivity::class.java)
                intent.putExtra(PostIndividualActivity.ARG_POST,post)
                startActivity(intent)

//                Toast.makeText(this@MainActivity, "it has been clicked on ${post.title} !", Toast.LENGTH_SHORT).show()
            }
        }

        val adapter = PostAdapter(this, postRepository.getPost(),postClickListener)
        recyclerView.adapter = adapter

    }

    interface OnPostClickListener {
        fun onClick(post: Post)
    }

}

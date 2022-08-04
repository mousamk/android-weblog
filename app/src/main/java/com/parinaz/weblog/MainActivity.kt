package com.parinaz.weblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val adapter = PostAdapter(this, postRepository.getPost())
        recyclerView.adapter = adapter
    }

}

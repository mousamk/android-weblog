package com.parinaz.weblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.parinaz.weblog.adapter.CommentAdapter
import com.parinaz.weblog.adapter.PostAdapter
import com.parinaz.weblog.databinding.ActivityMainBinding
import com.parinaz.weblog.databinding.ActivityPostIndividualBinding

class PostIndividualActivity : AppCompatActivity() {

    private val binding: ActivityPostIndividualBinding by lazy { ActivityPostIndividualBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val postRepository = PostRepository()


        val post = intent.getSerializableExtra(ARG_POST) as? Post
        if (post != null) {

            val recyclerView: RecyclerView = binding.commentsRecyclerview
            postRepository.getComments( { comments ->
                val adapter = CommentAdapter(this, comments,)
                recyclerView.adapter = adapter
            }, post.id)

            binding.postTitleIndividual.text = post.title
            binding.postBodyIndividual.text = post.body
        }
    }

    companion object {
        val ARG_POST = "arg.post"
    }
}
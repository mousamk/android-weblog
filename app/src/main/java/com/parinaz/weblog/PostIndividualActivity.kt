package com.parinaz.weblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
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
        val progressBar: ProgressBar = binding.progressbar

        val post = intent.getSerializableExtra(ARG_POST) as? Post
        if (post != null) {

            val recyclerView: RecyclerView = binding.commentsRecyclerview
            postRepository.getComments( { comments ->
                val adapter = CommentAdapter(this, comments,)
                recyclerView.adapter = adapter
            },{ message ->
                Toast.makeText(this, "An error has been occurred: ${message.orEmpty()}", Toast.LENGTH_SHORT).show()
              }, post.id)

            progressBar.visibility = View.GONE

            binding.postTitleIndividual.text = post.title
            binding.postBodyIndividual.text = post.body
        }
    }

    companion object {
        val ARG_POST = "arg.post"
    }
}
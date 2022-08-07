package com.parinaz.weblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.parinaz.weblog.databinding.ActivityMainBinding
import com.parinaz.weblog.databinding.ActivityPostIndividualBinding

class PostIndividualActivity : AppCompatActivity() {

    private val binding: ActivityPostIndividualBinding by lazy { ActivityPostIndividualBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val post = intent.getSerializableExtra("arg.post") as Post
        binding.postTitleIndividual.text = post.title
        binding.postBodyIndividual.text = post.body
    }
}
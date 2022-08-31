package com.parinaz.weblog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.parinaz.weblog.adapter.PostAdapter
import com.parinaz.weblog.databinding.ActivityPostIndividualBinding
import com.parinaz.weblog.databinding.ActivitySplashBinding
import org.w3c.dom.Text

class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val textSplash : TextView = binding.textSplash
        val postRepository = PostRepository

        postRepository.loadPosts({ posts ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, { message ->
            Toast.makeText(this, "An error has been occurred: ${message.orEmpty()}", Toast.LENGTH_SHORT).show()
        })
    }
}

package com.parinaz.weblog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.parinaz.weblog.databinding.ActivityPostIndividualBinding
import com.parinaz.weblog.databinding.ActivitySplashBinding
import org.w3c.dom.Text

class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val textSplash : TextView = binding.textSplash

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
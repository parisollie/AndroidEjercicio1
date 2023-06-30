package com.pjff.androidejercicio1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.pjff.androidejercicio1.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btStart = findViewById<Button>(R.id.btStart)

        btStart.setOnClickListener {
            val firstIntent = Intent(this, FirstActivity::class.java)
            startActivity(firstIntent)
        }
    }
}
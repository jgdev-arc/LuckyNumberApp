package com.tlz.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b1: Button = findViewById(R.id.btn)
        val text: TextView = findViewById(R.id.textView)
        val editTxt: EditText = findViewById(R.id.editText)

        b1.setOnClickListener {
            var username = editTxt.text
            var intent = Intent(this, LuckyNumberActivity::class.java)

            intent.putExtra("name", username)

            startActivity(intent)
        }

    }
}
package com.tlz.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luckynumber)

        val text1: TextView = findViewById(R.id.text1)
        val luckyTxt: TextView = findViewById(R.id.luckyNumberText)
        val shareBtn: Button = findViewById(R.id.shareBtn)

        var username = receiveUserName()

        var randomNum = generateRandomNum()

        luckyTxt.setText("" + randomNum)

        shareBtn.setOnClickListener {
            shareData(username, randomNum)
        }
    }

    fun receiveUserName(): String {
        var bundle: Bundle? = intent.extras
        var username = bundle?.get("name").toString()
        return username
    }

    fun generateRandomNum(): Int {
        val randomNum = Random.nextInt(1000)
        return randomNum
    }

    fun shareData(username: String, num: Int) {
        var intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today!")
        intent.putExtra(Intent.EXTRA_TEXT, "Their lucky number is $num")
        startActivity(intent)
    }

}
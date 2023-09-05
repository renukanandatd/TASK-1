package com.example.mini_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var intentBtn:Button=findViewById<Button>(R.id.button1)
        intentBtn.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
            finish()
        })
    }
}
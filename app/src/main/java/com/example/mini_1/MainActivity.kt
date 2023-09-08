package com.example.mini_1

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
   lateinit var imageView : ImageView
   lateinit var button: Button
   val REQUEST_IMAGE_CAPTURE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.button2)

        button.setOnClickListener {

            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        try{
            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE)

        }
        catch(e:ActivityNotFoundException){
            Toast.makeText(this,"Error:" + e.localizedMessage,Toast.LENGTH_SHORT).show()

        }        }


        var intentBtn:Button=findViewById<Button>(R.id.button1)
        intentBtn.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
            finish()
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
        else{

        super.onActivityResult(requestCode, resultCode, data)

    }
    }
}
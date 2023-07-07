package com.example.wishcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }

    fun bdaycard(view: View) {

//        val name1 = findViewById<EditText>(R.id.nameInput)
//        val name = name1.text
////      Toast.makeText( this, "Your name is ${name1.text}", Toast.LENGTH_SHORT).show()
////        Toast.makeText( this, "Your name is $name", Toast.LENGTH_SHORT).show()
//
//        val intent = Intent(this, Birthdaycard::class.java)
//        startActivity(intent)
//        intent.putExtra(Birthdaycard.NAME_EXTRA,name)
////      intent.putExtra(Birthdaycard.Name_Extra ,name)

        val nameInput = findViewById<EditText>(R.id.nameInput)

        val name = nameInput.editableText.toString()

        val intent = Intent(this, Birthdaycard::class.java)
        intent.putExtra(Birthdaycard.NAME_EXTRA, name)
        startActivity(intent)

    }

    fun anncard(view: View) {
        val nameInput = findViewById<EditText>(R.id.nameInput)

        val name = nameInput.editableText.toString()

        val intent = Intent(this, anniversary::class.java)
        intent.putExtra(anniversary.NAME_EXTRA, name)
        startActivity(intent)


    }
}
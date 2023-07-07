package com.example.wishcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Birthdaycard : AppCompatActivity() {

    companion object{
        const val NAME_EXTRA = "name_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthdaycard)

//        val name = intent.get(Name_Extra)
//        Toast.makeText(this, "name is $name", Toast.LENGTH_SHORT).show()
//        val wish = findViewById<TextView>(R.id.wish)
//
//        wish.text = "Happy Birthday $name"

        val wish = findViewById<TextView>(R.id.wish)

        val name = intent.getStringExtra(NAME_EXTRA)
        val name_cake = findViewById<TextView>(R.id.name_cake)
        name_cake.text = "$name"
        wish.text = "Happy Birthday $name"
    }

}
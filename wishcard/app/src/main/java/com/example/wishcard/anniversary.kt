package com.example.wishcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class anniversary : AppCompatActivity() {
    companion object {
        const val NAME_EXTRA = "name_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anniversary)


        val wish = findViewById<TextView>(R.id.wish)

        val name = intent.getStringExtra(NAME_EXTRA)
        wish.text = "Happy Anniversary $name"
    }
}
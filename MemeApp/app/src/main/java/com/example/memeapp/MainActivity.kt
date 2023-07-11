package com.example.memeapp

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class MainActivity : AppCompatActivity() {
    var currenturl : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadmeme()
        setContentView(R.layout.activity_main)

    }
    private fun loadmeme(){
//        findViewById<ProgressBar>(R.id.progressbar).visibility = View.VISIBLE
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.com/gimme"
        val JsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url,null,
            Response.Listener { response ->
                currenturl = response.getString("url")
                Glide.with(this).load(currenturl)
                    .listener(object: RequestListener<Drawable>{
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        findViewById<ProgressBar>(R.id.progressbar).visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        findViewById<ProgressBar>(R.id.progressbar).visibility = View.GONE
                        return false
                    }
                })
                    .into(findViewById<ImageView>(R.id.meme))
            },
            Response.ErrorListener {

            })

        queue.add(JsonObjectRequest)
    }



    fun shareme(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Hey Bro !!! Check this meme $currenturl")
        val chooser = Intent.createChooser(intent,"Share this with...")
        startActivity(chooser)

    }

    fun nextme(view: View) {
        loadmeme()
    }
}
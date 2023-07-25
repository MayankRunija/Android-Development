package com.example.newsapp
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest


class MainActivity : AppCompatActivity(), NewsItemClick {

    private lateinit var mAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recycle)
        recyclerview.layoutManager = LinearLayoutManager(this)
        fetchdata()
        mAdapter = NewsAdapter(this)
        recyclerview.adapter = mAdapter

    }

    private fun fetchdata() {
        val url =
//            "https://newsapi.org/v2/everything?q=tesla&from=2023-06-14&sortBy=publishedAt&apiKey=6260ce46a16844cc88ecdf8fdb74bda1"
            "https://saurav.tech/NewsAPI/top-headlines/category/sports/in.json"
//            "https://newsapi.org/v2/top-headlines?country=in&apiKey=6260ce46a16844cc88ecdf8fdb74bda1"
        val JsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url, null,
            Response.Listener {
                val newsjsonarray = it.getJSONArray("articles")
                val newsarry = ArrayList<News>()
                for(i in 0 until newsjsonarray.length()){
                    val newsjsonobject = newsjsonarray.getJSONObject(i)
                    val news = News(
                        newsjsonobject.getString("title"),
                        newsjsonobject.getString("author"),
                        newsjsonobject.getString("url"),
                        newsjsonobject.getString("urlToImage")

                    )
                    newsarry.add(news)
                }

                mAdapter.updatenews(newsarry)
            },
            Response.ErrorListener {
            }
        )

    MySingleton.getInstance(this).addToRequestQueue(JsonObjectRequest)

        }
    override fun getHeaders(): MutableMap<String, String> {
        val headers = HashMap<String, String>()
        headers["User-Agent"]="Mozilla/5.0"
        return headers

    }

    override fun onitemclick(item: News) {
        val url = item.url
            val intent: CustomTabsIntent = CustomTabsIntent.Builder()
            .build()
        intent.launchUrl(this@MainActivity, Uri.parse(url))
    }
}

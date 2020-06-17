package com.example.picasso

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class MainActivity : AppCompatActivity() {

    var imageList : MutableList<ItemOfList> = mutableListOf<ItemOfList>()
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        load.setOnClickListener{
            imageList.clear()

            for(count in 1..4){
                run("https://aws.random.cat/meow")
            }

            while (imageList.size != 4)
            {
                Thread.sleep(1000)
            }

            val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = ItemAdapter(imageList.toList())
        }

    }

    private fun run(url: String){
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException){
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response){
                val json = response.body()?.string()
                imageList.add(ItemOfList((JSONObject(json).get("file")).toString()))
            }
        })
    }
}

package com.tts.icore

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FavouriteAdapter.ClickListener {

    var set: HashSet<String> = HashSet()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list = ArrayList<String>(
            listOf(
                "Action",
                "Adventure",
                "Fantasy",
                "Humour & Comedy",
                "Inspiration & Compassion",
                "Legend & Lore",
                "Non-Categorized",
                "Realistic Fiction",
                "Romance",
                "Science Fiction",
                "Social",
                "Surreal & Whimsical",
                "Suspense & Thriller"
            )
        )

        recyclerView.layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)
        recyclerView.adapter = FavouriteAdapter(list, this)

        btnSave.setOnClickListener {
            Toast.makeText(this, set.toString(), Toast.LENGTH_SHORT).show()
        }

        btnProductList.setOnClickListener {
            startActivity(Intent(this, ProductListActivity::class.java))
        }


    }

    override fun selectedItem(item: HashSet<String>) {
        set = item
    }
}
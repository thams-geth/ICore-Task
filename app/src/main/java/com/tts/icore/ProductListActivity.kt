package com.tts.icore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        var list = ArrayList<Product>()
        for (i in 1..50) {

            list.add(
                Product(
                    "Lorem ipsum, or lipsum as it is sometimes known",
                    "The passage is attributed to an unknown typesetter in the 15th century who is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type specimen book"
                )
            )
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductListAdapter(list, this)

    }
}
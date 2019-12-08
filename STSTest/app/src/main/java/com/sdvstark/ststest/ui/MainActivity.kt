package com.sdvstark.ststest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sdvstark.ststest.R
import com.sdvstark.ststest.adapter.MainAdapter
import com.sdvstark.ststest.util.generateEntityList
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(recyclerView) {
            adapter = MainAdapter().also {

                it.onItemClickListener = { entityInfoModel ->
                    DetailedActivity.startActivity(
                        this@MainActivity,
                        entityInfoModel as Serializable
                    )
                }

                it.update(generateEntityList())
            }

            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(this@MainActivity, RecyclerView.VERTICAL))
        }
    }
}

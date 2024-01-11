package com.bit2b.gear.ui.search

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bit2b.gear.R
import com.bit2b.gear.databinding.ActivitySearchListBinding

class SearchListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val adapter = SearchListAdapter()
        binding.searchListRV.adapter = adapter
        binding.searchListRV.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }
}
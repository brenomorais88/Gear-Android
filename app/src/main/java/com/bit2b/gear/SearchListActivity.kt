package com.bit2b.gear

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bit2b.gear.databinding.ActivitySearchListBinding

class SearchListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
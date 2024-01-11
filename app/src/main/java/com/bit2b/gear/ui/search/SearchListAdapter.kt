package com.bit2b.gear.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bit2b.gear.databinding.ItemCarListBinding

class SearchListAdapter: RecyclerView.Adapter<SearchListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListViewHolder {
        val itemMatchBinding = ItemCarListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchListViewHolder(itemMatchBinding)
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: SearchListViewHolder, position: Int) {

    }
}
class SearchListViewHolder(private val itemCarListBinding: ItemCarListBinding) :
        RecyclerView.ViewHolder(itemCarListBinding.root){

        }
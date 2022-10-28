package com.example.githubtrendingrepositories.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubtrendingrepositories.R
import com.example.githubtrendingrepositories.domain.trending_repo.TrendingRepo
import com.example.githubtrendingrepositories.presentation.viewholder.TrendingRepoViewHolder

class TrendingRepoRecyclerViewAdapter(private val trendingRepoList: MutableList<TrendingRepo>) :
    RecyclerView.Adapter<TrendingRepoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingRepoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return TrendingRepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrendingRepoViewHolder, position: Int) {
        holder.userName.text = trendingRepoList[position].name
    }

    override fun getItemCount() = trendingRepoList.size
}
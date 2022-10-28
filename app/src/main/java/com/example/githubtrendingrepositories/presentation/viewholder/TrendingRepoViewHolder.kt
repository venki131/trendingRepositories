package com.example.githubtrendingrepositories.presentation.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubtrendingrepositories.R

class TrendingRepoViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var userName: TextView
    init {
        userName = view.findViewById(R.id.username)
    }
}
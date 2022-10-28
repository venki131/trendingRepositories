package com.example.githubtrendingrepositories.presentation.state

import com.example.githubtrendingrepositories.domain.trending_repo.TrendingRepo

data class TrendingRepoState(
    val trendingRepoList: ArrayList<TrendingRepo>? = arrayListOf(),
    val isLoading: Boolean = false,
    val error: String? = null
)
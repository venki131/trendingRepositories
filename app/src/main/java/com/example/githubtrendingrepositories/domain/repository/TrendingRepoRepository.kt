package com.example.githubtrendingrepositories.domain.repository

import com.example.githubtrendingrepositories.domain.trending_repo.TrendingRepo
import com.example.githubtrendingrepositories.domain.util.Resource

interface TrendingRepoRepository {

    suspend fun getTrendingRepo(
        language: String? = "",
        since: String? = "",
        spokenLangCode: String? = ""
    ): Resource<ArrayList<TrendingRepo>>
}
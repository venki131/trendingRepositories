package com.example.githubtrendingrepositories.data.repository

import com.example.githubtrendingrepositories.data.remote.TrendingRepoApi
import com.example.githubtrendingrepositories.data.remote.toTrendingRepo
import com.example.githubtrendingrepositories.domain.repository.TrendingRepoRepository
import com.example.githubtrendingrepositories.domain.trending_repo.TrendingRepo
import com.example.githubtrendingrepositories.domain.util.Resource
import javax.inject.Inject

class TrendingRepoRepositoryImpl @Inject constructor(
    private val api: TrendingRepoApi
) : TrendingRepoRepository {

    override suspend fun getTrendingRepo(
        language: String?,
        since: String?,
        spokenLangCode: String?
    ): Resource<ArrayList<TrendingRepo>> {
        return try {
            Resource.Success(
                data = api.getTrendingRepo(
                    language,
                    since,
                    spokenLangCode
                ).map { it.toTrendingRepo() } as? ArrayList<TrendingRepo>
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(
                e.message ?: "An unknown error occurred"
            )
        }
    }
}
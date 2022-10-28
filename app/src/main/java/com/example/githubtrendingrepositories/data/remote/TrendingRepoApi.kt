package com.example.githubtrendingrepositories.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface TrendingRepoApi {

    @GET("repositories")
    suspend fun getTrendingRepo(
        @Query("language") language: String? = "",
        @Query("since") since: String? = "",
        @Query("spoken_language_code") spokenLanguageCode: String? = ""
    ): ArrayList<TrendingRepoDtoItem>

}
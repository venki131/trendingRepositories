package com.example.githubtrendingrepositories.data.remote

import android.os.Parcelable
import com.example.githubtrendingrepositories.domain.trending_repo.TrendingRepo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrendingRepoDtoItem(
    @SerializedName("author")
    @Expose
    val author: String = "",
    @SerializedName("avatar")
    @Expose
    val avatar: String = "",
    @SerializedName("builtBy")
    @Expose
    val builtBy: List<BuiltBy> = listOf(),
    @SerializedName("currentPeriodStars")
    @Expose
    val currentPeriodStars: Int = 0,
    @SerializedName("description")
    @Expose
    val description: String = "",
    @SerializedName("forks")
    @Expose
    val forks: Int = 0,
    @SerializedName("language")
    @Expose
    val language: String = "",
    @SerializedName("languageColor")
    @Expose
    val languageColor: String = "",
    @SerializedName("name")
    @Expose
    val name: String = "",
    @SerializedName("stars")
    @Expose
    val stars: Int = 0,
    @SerializedName("url")
    @Expose
    val url: String = ""
) : Parcelable {
    @Parcelize
    data class BuiltBy(
        @SerializedName("avatar")
        @Expose
        val avatar: String = "",
        @SerializedName("href")
        @Expose
        val href: String = "",
        @SerializedName("username")
        @Expose
        val username: String = ""
    ) : Parcelable
}

fun TrendingRepoDtoItem.BuiltBy.toBuiltBy() = TrendingRepo.BuiltBy(
    avatar = avatar,
    href = href,
    username = username
)


fun TrendingRepoDtoItem.toTrendingRepo() = TrendingRepo(
    author = author,
    avatar = avatar,
    builtBy = builtBy.map { it.toBuiltBy() },
    currentPeriodStars = currentPeriodStars,
    description = description,
    forks = forks,
    language = language,
    languageColor = languageColor,
    name = name,
    stars = stars,
    url = url
)
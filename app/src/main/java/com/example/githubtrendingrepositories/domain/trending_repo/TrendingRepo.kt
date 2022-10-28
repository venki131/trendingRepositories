package com.example.githubtrendingrepositories.domain.trending_repo

data class TrendingRepo(
    val author: String = "",
    val avatar: String = "",
    val builtBy: List<BuiltBy> = listOf(),
    val currentPeriodStars: Int = 0,
    val description: String = "",
    val forks: Int = 0,
    val language: String = "",
    val languageColor: String = "",
    val name: String = "",
    val stars: Int = 0,
    val url: String = ""
) {
    data class BuiltBy(
        val avatar: String = "",
        val href: String = "",
        val username: String = ""
    )
}

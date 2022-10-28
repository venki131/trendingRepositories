package com.example.githubtrendingrepositories.presentation.view_models

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtrendingrepositories.domain.repository.TrendingRepoRepository
import com.example.githubtrendingrepositories.domain.trending_repo.TrendingRepo
import com.example.githubtrendingrepositories.domain.util.Resource
import com.example.githubtrendingrepositories.presentation.state.TrendingRepoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingRepoViewModel @Inject constructor(
    private val repository: TrendingRepoRepository
) : ViewModel() {

    private var mutableLiveData: MutableLiveData<TrendingRepoState> = MutableLiveData()
    val liveData: MutableLiveData<TrendingRepoState> get() = mutableLiveData

    /*var state by mutableStateOf(TrendingRepoState())
        private set*/

    fun getTrendingRepo() {
        viewModelScope.launch {
            when (val result = repository.getTrendingRepo()) {
                is Resource.Loading -> {
                    /*state = state.copy(
                        trendingRepoList = result.data,
                        isLoading = result.loadingStatus,
                        error = result.message
                    )*/
                    mutableLiveData.value = TrendingRepoState(
                        trendingRepoList = result.data,
                        isLoading = result.loadingStatus,
                        error = result.message
                    )
                }
                is Resource.Success -> {
                    /*state = state.copy(
                        trendingRepoList = result.data,
                        isLoading = result.loadingStatus,
                        error = result.message
                    )*/
                    mutableLiveData.value = TrendingRepoState(
                        trendingRepoList = result.data,
                        isLoading = result.loadingStatus,
                        error = result.message
                    )
                }
                is Resource.Failure -> {
                    /*state = state.copy(
                        trendingRepoList = result.data,
                        isLoading = result.loadingStatus,
                        error = result.message
                    )*/
                    mutableLiveData.value = TrendingRepoState(
                        trendingRepoList = result.data,
                        isLoading = result.loadingStatus,
                        error = result.message
                    )
                    Log.e("Error", result.message ?: "Unknown error")
                }
            }
        }
    }
}
package com.example.githubtrendingrepositories.presentation.view_models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtrendingrepositories.domain.repository.TrendingRepoRepository
import com.example.githubtrendingrepositories.domain.trending_repo.TrendingRepo
import com.example.githubtrendingrepositories.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingRepoViewModel @Inject constructor(
    private val repository: TrendingRepoRepository
) : ViewModel() {

    private var mutableLiveData: MutableLiveData<ArrayList<TrendingRepo>> = MutableLiveData()
    val liveData : LiveData<ArrayList<TrendingRepo>> get() = mutableLiveData

    fun getTrendingRepo() {
        viewModelScope.launch {
            when (val result = repository.getTrendingRepo()) {
                is Resource.Success -> {
                    mutableLiveData.value = result.data
                    Log.d("desc", result.data?.get(0)?.description ?: "Nothing to display")
                }

                is Resource.Failure -> {
                    mutableLiveData.value = result.data
                    Log.e("Error", result.message ?: "Unknown error")
                }
            }
        }
    }
}
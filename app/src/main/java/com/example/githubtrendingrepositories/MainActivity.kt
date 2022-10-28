package com.example.githubtrendingrepositories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.githubtrendingrepositories.presentation.view_models.TrendingRepoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: TrendingRepoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getTrendingRepo()
        observe()
    }

    private fun observe() {
        viewModel.liveData.observe(this) {
            println("resulting value = $it")
        }
    }
}
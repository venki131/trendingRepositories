package com.example.githubtrendingrepositories.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.githubtrendingrepositories.R
import com.example.githubtrendingrepositories.domain.trending_repo.TrendingRepo
import com.example.githubtrendingrepositories.presentation.adapters.TrendingRepoRecyclerViewAdapter
import com.example.githubtrendingrepositories.presentation.view_models.TrendingRepoViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TrendingRepoListFragment : Fragment() {

    private val viewModel: TrendingRepoViewModel by viewModels()
    private val trendingRepoList: MutableList<TrendingRepo> = arrayListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TrendingRepoRecyclerViewAdapter
    private lateinit var progressBar: ProgressBar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending_repo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        initRecyclerView()
        initView()
        (activity as AppCompatActivity?)?.supportActionBar?.title = "Trending"
        viewModel.getTrendingRepo()
    }

    private fun initObserver() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            progressVisibility(it.isLoading)
            handleError(it.error)
            it?.trendingRepoList?.let { repoList ->
                initAdapter(repoList)
            }
        }
    }

    private fun initView() {
        progressBar = this.requireView().findViewById(R.id.progressbar)
    }

    private fun initAdapter(list: ArrayList<TrendingRepo>?) {
        list?.let {
            trendingRepoList.addAll(it)
        }
        recyclerView.adapter = adapter
    }

    private fun initRecyclerView() {
        recyclerView = this.requireView().findViewById(R.id.recyclerview)
        adapter = TrendingRepoRecyclerViewAdapter(trendingRepoList)
    }

    private fun progressVisibility(isVisible: Boolean) {
        if (isVisible)
            progressBar.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    private fun handleError(message: String?) {
        message?.let {
            Log.e("Error", it)
        }
    }
}
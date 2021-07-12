package com.example

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_android.R
import com.example.model.mainModel.MainReposResponse
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        mainViewModel.repos.observe(this) { setupList(it) }
        mainViewModel.fetchRepos()
    }

    private fun setupList(reposResponse: MainReposResponse) {
        val recyclerView = findViewById<RecyclerView>(R.id.mainRecycler)
        recyclerView.adapter = MainAdapter(reposResponse.items, this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }

}

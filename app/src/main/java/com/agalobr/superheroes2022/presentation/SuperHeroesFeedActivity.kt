package com.agalobr.superheroes2022.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.agalobr.superheroes2022.R
import com.agalobr.superheroes2022.domain.GetSuperHeroFeedUseCase
import com.agalobr.superheroes2022.domain.GetSuperHeroeFeedUseCase
import com.agalobr.superheroes2022.presentation.adapter.SuperHeroeAdapter
import com.example.superheroe2022.R
import kotlin.concurrent.thread

class SuperHeroesFeedActivity : AppCompatActivity() {

    private var binding: ActivitySuperheroeFeedBinding? = null
    private val superHeroAdapter = SuperHeroAdapter()
    private val viewModel by lazy {
        SuperHeroFactory().getSuperHerosViewModel(getSharedPreferences("superheroes", MODE_PRIVATE))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupView()
        loadSuperHeros()
    }

    private fun setupBinding() {
        binding = ActivitySuperheroeFeedBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }

    private fun setupView() {
        binding?.apply {
            listSuperheroe.adapter = superHeroAdapter
            listSuperheroe.layoutManager =
                LinearLayoutManager(
                    this@SuperHerosFeedActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
    }

    private fun loadSuperHeros() {
        viewModel.loadSuperHeros(object : SuperHeroCallback {
            override fun onCall(superHerosFeed: List<GetSuperHeroFeedUseCase.SuperHeroFeed>) {
                superHeroAdapter.setDataItems(superHerosFeed)
            }
        })
    }
}
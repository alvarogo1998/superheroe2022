package com.agalobr.superheroes2022.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.agalobr.superheroes2022.databinding.ViewItemSuperheroeFeedBinding
import com.agalobr.superheroes2022.domain.GetSuperHeroFeedUseCase
import com.agalobr.superheroes2022.domain.GetSuperHeroeFeedUseCase
import com.agalobr.superheroes2022.presentation.SuperHeroDetailActivity

class SuperHeroeViewHolder (private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(superHero: GetSuperHeroFeedUseCase.SuperHeroFeed) {
        val binding = ViewItemSuperheroeFeedBinding.bind(view)
        binding.imgSuperheroe.loadUrl(superHero.urlImage)
        binding.labelNameSuperheroe.text = superHero.nameSuperHero
        binding.labelRealnameSuperheroe.text = superHero.realName
        binding.labelOccupationSuperheroe.text = superHero.occupation
        view.setOnClickListener {
            view.context.startActivity(
                SuperHeroDetailActivity.getIntent(
                    view.context, superHero.id
                )
            )
        }
    }

}
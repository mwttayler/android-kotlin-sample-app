package com.maxtayler.punk.domain.usecase

import com.maxtayler.punk.domain.entity.BeerEntity
import com.maxtayler.punk.domain.repository.BeerRepository
import javax.inject.Inject

class ToggleBookmarkUseCase @Inject constructor(private val beerRepository: BeerRepository) {

    suspend operator fun invoke(beer: BeerEntity) = if (beer.isBookmarked) {
        beerRepository.removeBookmark(beer)
    } else {
        beerRepository.insertBookmark(beer)
    }
}
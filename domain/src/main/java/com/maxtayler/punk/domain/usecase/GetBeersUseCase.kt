package com.maxtayler.punk.domain.usecase

import com.maxtayler.punk.domain.repository.BeerRepository
import javax.inject.Inject

class GetBeersUseCase @Inject constructor(private val beerRepository: BeerRepository) {

    suspend operator fun invoke() = beerRepository.getBeers()
}

package com.maxtayler.punk.domain.usecase

import com.maxtayler.punk.domain.repository.BeerRepository
import javax.inject.Inject

class GetBeerUseCase @Inject constructor(private val beerRepository: BeerRepository) {

    suspend operator fun invoke(id: Long) = beerRepository.getBeer(id)
}

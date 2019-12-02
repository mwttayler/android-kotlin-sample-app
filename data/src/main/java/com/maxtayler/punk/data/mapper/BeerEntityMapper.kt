package com.maxtayler.punk.data.mapper

import com.maxtayler.punk.data.network.model.BeerResponse
import com.maxtayler.punk.domain.entity.BeerEntity
import javax.inject.Inject

internal class BeerEntityMapper @Inject constructor() : Mapper<BeerEntityMapper.Params, BeerEntity>() {

    override fun mapFrom(from: Params): BeerEntity {
        return BeerEntity(
            from.response.id,
            from.response.name.orEmpty(),
            from.response.image_url.orEmpty(),
            from.response.tagline.orEmpty(),
            from.bookmarks.any { it.id == from.response.id }
        )
    }

    data class Params(val response: BeerResponse, val bookmarks: List<BeerEntity>)
}
package com.maxtayler.punk.latest.viewstate

import com.maxtayler.punk.domain.entity.BeerEntity

internal sealed class ViewState {

    object Loading : ViewState()

    data class Success(val beers: List<BeerEntity>) : ViewState()

    data class Error(val throwable: Throwable) : ViewState()
}

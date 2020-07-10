package com.maxtayler.punk.bookmarks.viewstate

import com.maxtayler.punk.domain.entity.BeerEntity

internal sealed class ViewState {

    object Loading : ViewState()

    data class Success(val bookmarks: List<BeerEntity>) : ViewState()

    data class Error(val throwable: Throwable) : ViewState()
}

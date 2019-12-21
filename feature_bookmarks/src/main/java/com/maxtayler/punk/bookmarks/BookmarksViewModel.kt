package com.maxtayler.punk.bookmarks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxtayler.punk.domain.entity.BeerEntity
import com.maxtayler.punk.domain.usecase.GetBookmarksUseCase
import com.maxtayler.punk.domain.usecase.ToggleBookmarkUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BookmarksViewModel @Inject constructor(
    private val getBookmarks: GetBookmarksUseCase,
    private val toggleBookmark: ToggleBookmarkUseCase
) : ViewModel() {

    private val _bookmarks: MutableLiveData<List<BeerEntity>> = MutableLiveData()
    val bookmarks: LiveData<List<BeerEntity>> = _bookmarks

    fun load() {
        viewModelScope.launch {
            getBookmarks().collect { _bookmarks.value = it }
        }
    }

    fun onBookmarkClicked(beer: BeerEntity) {
        viewModelScope.launch { toggleBookmark(beer) }
    }
}

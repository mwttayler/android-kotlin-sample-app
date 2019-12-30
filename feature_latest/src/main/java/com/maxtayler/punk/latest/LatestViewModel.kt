package com.maxtayler.punk.latest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxtayler.punk.domain.entity.BeerEntity
import com.maxtayler.punk.domain.usecase.GetBeersUseCase
import com.maxtayler.punk.domain.usecase.ToggleBookmarkUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LatestViewModel @Inject constructor(
    private val getBeers: GetBeersUseCase,
    private val toggleBookmark: ToggleBookmarkUseCase
) : ViewModel() {

    private val _beers: MutableLiveData<List<BeerEntity>> = MutableLiveData()
    val beers: LiveData<List<BeerEntity>> = _beers

    fun load() {
        viewModelScope.launch {
            getBeers().collect { _beers.value = it }
        }
    }

    fun onBookmarkClicked(beer: BeerEntity) {
        viewModelScope.launch { toggleBookmark(beer) }
    }
}

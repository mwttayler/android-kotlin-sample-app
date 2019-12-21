package com.maxtayler.punk.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxtayler.punk.domain.entity.BeerEntity
import com.maxtayler.punk.domain.usecase.GetBeerUseCase
import com.maxtayler.punk.domain.usecase.ToggleBookmarkUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailsViewModel @Inject constructor(
    private val getBeer: GetBeerUseCase,
    private val toggleBookmark: ToggleBookmarkUseCase
) : ViewModel() {

    private val _beer: MutableLiveData<BeerEntity> = MutableLiveData()
    val beer: LiveData<BeerEntity> = _beer

    fun load(beerId: Long) {
        viewModelScope.launch {
            getBeer(beerId).collect { _beer.value = it }
        }
    }

    fun onBookmarkClicked(beer: BeerEntity) {
        viewModelScope.launch { toggleBookmark(beer) }
    }
}

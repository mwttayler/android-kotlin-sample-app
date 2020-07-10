package com.maxtayler.punk.latest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxtayler.punk.domain.entity.BeerEntity
import com.maxtayler.punk.domain.usecase.GetBeersUseCase
import com.maxtayler.punk.domain.usecase.ToggleBookmarkUseCase
import com.maxtayler.punk.latest.viewstate.ViewState
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

internal class LatestViewModel @Inject constructor(
    private val getBeers: GetBeersUseCase,
    private val toggleBookmark: ToggleBookmarkUseCase
) : ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(throwable)
        _viewState.value = ViewState.Error(throwable)
    }
    private val _viewState: MutableLiveData<ViewState> = MutableLiveData()
    val viewState: LiveData<ViewState> = _viewState

    fun onViewCreated() {
        viewModelScope.launch(coroutineExceptionHandler) {
            _viewState.value = ViewState.Loading
            getBeers().collect { _viewState.value = ViewState.Success(it) }
        }
    }

    fun onBookmarkClicked(beer: BeerEntity) {
        viewModelScope.launch { toggleBookmark(beer) }
    }
}

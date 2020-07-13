package com.maxtayler.punk.bookmarks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.maxtayler.punk.base.BaseFragment
import com.maxtayler.punk.bookmarks.viewstate.ViewState
import com.maxtayler.punk.di.viewmodel.ViewModelFactory
import com.maxtayler.punk.domain.entity.BeerEntity
import com.maxtayler.punk.groupie.BeerItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_bookmarks.*

@AndroidEntryPoint
class BookmarksFragment : BaseFragment(R.layout.fragment_bookmarks) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: BookmarksViewModel by viewModels { viewModelFactory }
    private val groupAdapter = GroupAdapter<GroupieViewHolder>()

    init {
        groupAdapter.setOnItemClickListener { item, _ ->
            if (item is BeerItem) {
                findNavController().navigate(
                    BookmarksFragmentDirections.actionBookmarksToDetails(item.id)
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        viewModel.viewState.observe(viewLifecycleOwner, Observer(::renderViewState))
        viewModel.onViewCreated()
    }

    private fun initViews() {
        recycler_view.adapter = groupAdapter
        swipe_refresh_layout.isEnabled = false
    }

    private fun renderViewState(viewState: ViewState) {
        when (viewState) {
            is ViewState.Loading -> renderLoading()
            is ViewState.Success -> renderBookmarks(viewState.bookmarks)
            is ViewState.Error -> renderError(viewState.throwable)
        }
    }

    private fun renderLoading() {
        swipe_refresh_layout.isRefreshing = true
    }

    private fun renderBookmarks(bookmarks: List<BeerEntity>) {
        swipe_refresh_layout.isRefreshing = false

        val items = bookmarks.map { BeerItem(it, viewModel::onBookmarkClicked) }
        groupAdapter.update(items)
    }

    private fun renderError(throwable: Throwable) {
        swipe_refresh_layout.isRefreshing = false

        throwable.message?.run {
            Snackbar.make(coordinator, this, Snackbar.LENGTH_SHORT).show()
        }
    }
}

package com.maxtayler.punk.bookmarks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.maxtayler.punk.PunkApplication.Companion.singletonComponent
import com.maxtayler.punk.base.BaseFragment
import com.maxtayler.punk.bookmarks.di.DaggerBookmarksComponent
import com.maxtayler.punk.di.viewmodel.ViewModelFactory
import com.maxtayler.punk.domain.entity.BeerEntity
import com.maxtayler.punk.groupie.BeerItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_bookmarks.*
import javax.inject.Inject

class BookmarksFragment : BaseFragment() {

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

    override fun provideLayoutId(): Int {
        return R.layout.fragment_bookmarks
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerBookmarksComponent.factory()
            .create(context.singletonComponent)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.adapter = groupAdapter

        viewModel.bookmarks.observe(viewLifecycleOwner, Observer(::renderBookmarks))
        viewModel.load()
    }

    private fun renderBookmarks(bookmarks: List<BeerEntity>) {
        val items = bookmarks.map { BeerItem(it, viewModel::onBookmarkClicked) }
        groupAdapter.update(items)
    }
}
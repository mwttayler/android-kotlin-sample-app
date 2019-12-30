package com.maxtayler.punk.latest

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.maxtayler.core.CoreApplication.Companion.singletonComponent
import com.maxtayler.core.base.BaseFragment
import com.maxtayler.core.di.viewmodel.ViewModelFactory
import com.maxtayler.punk.domain.entity.BeerEntity
import com.maxtayler.punk.groupie.BeerItem
import com.maxtayler.punk.latest.di.DaggerLatestComponent
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_latest.*

class LatestFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: LatestViewModel by viewModels { viewModelFactory }
    private val groupAdapter = GroupAdapter<GroupieViewHolder>()

    init {
        groupAdapter.setOnItemClickListener { item, _ ->
            if (item is BeerItem) {
                findNavController().navigate(
                    LatestFragmentDirections.actionLatestToDetails(item.id)
                )
            }
        }
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_latest
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerLatestComponent.factory()
            .create(context.singletonComponent)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.adapter = groupAdapter

        viewModel.beers.observe(viewLifecycleOwner, Observer(::renderBeers))
        viewModel.load()
    }

    private fun renderBeers(beers: List<BeerEntity>) {
        val items = beers.map { BeerItem(it, viewModel::onBookmarkClicked) }
        groupAdapter.update(items)
    }
}

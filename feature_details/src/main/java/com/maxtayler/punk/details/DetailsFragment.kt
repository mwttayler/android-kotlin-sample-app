package com.maxtayler.punk.details

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.maxtayler.punk.PunkApplication.Companion.singletonComponent
import com.maxtayler.punk.base.BaseFragment
import com.maxtayler.punk.details.di.DaggerDetailsComponent
import com.maxtayler.punk.di.viewmodel.ViewModelFactory
import com.maxtayler.punk.domain.entity.BeerEntity
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

class DetailsFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: DetailsViewModel by viewModels { viewModelFactory }
    private val args: DetailsFragmentArgs by navArgs()

    override fun provideLayoutId(): Int {
        return R.layout.fragment_details
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerDetailsComponent.factory()
            .create(context.singletonComponent)
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.beer.observe(viewLifecycleOwner, Observer(::renderBeer))
        viewModel.load(args.beerId)
    }

    private fun renderBeer(beer: BeerEntity) {
        title.text = "beer = ${beer.title}"
    }
}

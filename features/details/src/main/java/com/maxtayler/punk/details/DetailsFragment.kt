package com.maxtayler.punk.details

import com.maxtayler.punk.R as appR
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import coil.api.load
import com.maxtayler.punk.PunkApplication.Companion.singletonComponent
import com.maxtayler.punk.base.BaseFragment
import com.maxtayler.punk.details.di.DaggerDetailsComponent
import com.maxtayler.punk.di.viewmodel.ViewModelFactory
import com.maxtayler.punk.domain.entity.BeerEntity
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

class DetailsFragment : BaseFragment(R.layout.fragment_details) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: DetailsViewModel by viewModels { viewModelFactory }
    private val args: DetailsFragmentArgs by navArgs()

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

        toolbar.navigationIcon = ContextCompat.getDrawable(requireContext(), appR.drawable.ic_back)
        toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
    }

    private fun renderBeer(beer: BeerEntity) {
        toolbar.title = beer.title
        image.load(beer.imageUrl)
        tag_line.text = beer.tagLine
        description.text = beer.description
    }
}

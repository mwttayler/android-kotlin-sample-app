package com.maxtayler.punk.groupie

import com.maxtayler.punk.R
import com.maxtayler.punk.databinding.ListItemBeerBinding
import com.maxtayler.punk.domain.entity.BeerEntity
import com.xwray.groupie.Item
import com.xwray.groupie.databinding.BindableItem

data class BeerItem(
    private val beer: BeerEntity,
    private val onBookmarkCLicked: (BeerEntity) -> Unit
) : BindableItem<ListItemBeerBinding>(beer.id) {

    override fun bind(viewBinding: ListItemBeerBinding, position: Int) {
        viewBinding.beer = beer
        viewBinding.iconBookmark.setOnClickListener { onBookmarkCLicked.invoke(beer) }
    }

    override fun hasSameContentAs(other: Item<*>?): Boolean {
        return other is BeerItem && other.beer.hashCode() == beer.hashCode()
    }

    override fun getLayout(): Int {
        return R.layout.list_item_beer
    }
}

package com.test.privatatms.presentation.adapter.viewholders

import android.view.View
import androidx.core.content.ContextCompat
import com.test.privatatms.R
import com.test.privatatms.model.atm.Atm
import com.test.privatatms.presentation.adapter.BaseViewHolder
import com.test.privatatms.presentation.adapter.model.ListItem
import kotlinx.android.synthetic.main.item_atm.view.*

class AtmViewHolder(itemView: View) : BaseViewHolder(itemView) {

    override fun bind(item: ListItem) {
        if(item !is Atm) return
        itemView.apply {
            atmCityTextView.text = item.cityRU
            atmAddressTextView.text = item.fullAddressRu
            if (item.isFavourite) {
                atmFavouriteImageView
                    .setImageDrawable(
                        ContextCompat.getDrawable(
                            itemView.context,
                            R.drawable.ic_favorite
                        )
                    )
            } else {
                atmFavouriteImageView
                    .setImageDrawable(
                        ContextCompat.getDrawable(
                            itemView.context,
                            R.drawable.ic_favorite_border
                        )
                    )
            }
        }
    }

    override fun rebind(item: ListItem) {
        if(item !is Atm) return
        if (item.isFavourite) {
            itemView.atmFavouriteImageView
                .setImageDrawable(
                    ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.ic_favorite
                    )
                )
        } else {
            itemView.atmFavouriteImageView
                .setImageDrawable(
                    ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.ic_favorite_border
                    )
                )
        }
    }
}
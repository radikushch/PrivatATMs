package com.test.privatatms.presentation.atm_list.adapter

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.test.privatatms.R
import com.test.privatatms.extensions.invisible
import com.test.privatatms.extensions.visible
import com.test.privatatms.model.Atm
import kotlinx.android.synthetic.main.item_atm.view.*

class AtmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(atm: Atm) {
        itemView.apply {
            atmCityTextView.text = atm.cityRU
            atmAddressTextView.text = atm.fullAddressRu
            if (atm.isFavourite) {
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

    fun rebind(atm: Atm) {
        if (atm.isFavourite) {
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
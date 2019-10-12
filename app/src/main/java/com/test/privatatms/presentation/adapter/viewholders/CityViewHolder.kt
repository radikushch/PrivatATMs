package com.test.privatatms.presentation.adapter.viewholders

import android.view.View
import android.widget.TextView
import com.test.privatatms.model.city.City
import com.test.privatatms.presentation.adapter.BaseViewHolder
import com.test.privatatms.presentation.adapter.model.ListItem

class CityViewHolder(itemView: View) : BaseViewHolder(itemView) {
    override fun bind(item: ListItem) {
        if(item !is City) return
        (itemView as TextView).text = item.name
    }

    override fun rebind(item: ListItem) {
        bind(item)
    }
}
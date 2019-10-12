package com.test.privatatms.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.test.privatatms.presentation.adapter.model.ListItem

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: ListItem)
    abstract fun rebind(item: ListItem)
}
package com.test.privatatms.presentation.adapter

import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.privatatms.R
import com.test.privatatms.consts.ViewTypeConsts
import com.test.privatatms.presentation.adapter.model.ListItem
import com.test.privatatms.presentation.adapter.model.SearchItem
import com.test.privatatms.presentation.adapter.viewholders.AtmViewHolder
import com.test.privatatms.presentation.adapter.viewholders.CityViewHolder
import kotlinx.android.synthetic.main.item_atm.view.*

class SearchAdapter(
    private var data: MutableList<SearchItem> = ArrayList(),
    private val onItemClick: (item: SearchItem) -> Unit = {},
    private val onFavoriteClick: (item: SearchItem) -> Unit = {},
    private val foregroundColorSpan: ForegroundColorSpan
) : RecyclerView.Adapter<BaseViewHolder>(){

    private val fullDataList = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            ViewTypeConsts.CITY_VIEW_TYPE -> {
                CityViewHolder(
                    inflater.inflate(R.layout.item_city, parent, false)
                ).apply {
                    itemView.setOnClickListener {
                        onItemClick.invoke(data[adapterPosition])
                    }
                }
            }
            ViewTypeConsts.ATM_VIEW_TYPE -> {
                AtmViewHolder(
                    inflater.inflate(R.layout.item_atm, parent, false)
                ).apply {
                    itemView.setOnClickListener {
                        onItemClick.invoke(data[adapterPosition])
                    }
                    itemView.atmFavouriteImageView.setOnClickListener {
                        onFavoriteClick.invoke(data[adapterPosition])
                        notifyItemChanged(adapterPosition, adapterPosition)
                    }
                }
            }
            else -> {
                object : BaseViewHolder(View(parent.context)) {
                    override fun bind(item: ListItem) {}
                    override fun rebind(item: ListItem) {}
                }
            }
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].getViewType()
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if(payloads.isNotEmpty()) {
            holder.rebind(data[position])
        }else {
            holder.bind(data[position])
        }
    }

    fun search(textPattern: String) {
        updateSearch(textPattern)
        highlight(textPattern)
    }

    fun swapData(newData: List<SearchItem>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    private fun updateSearch(textPattern: String) {
        data = if (textPattern.isEmpty()) {
            fullDataList
        } else {
            fullDataList.filter {
                it.getSearchField().contains(textPattern, true)
            } as ArrayList
        }
        notifyDataSetChanged()
    }

    private fun highlight(textPattern: String) {
        data.forEach { item ->
            item.getSearchField()
                .getSpans(0, item.getSearchField().length, ForegroundColorSpan::class.java)
                .forEach {
                    item.getSearchField().removeSpan(it)
                }

            if (item.getSearchField().contains(textPattern, true)) {
                val index = item.getSearchField().toString().indexOf(textPattern, 0, true)
                item.getSearchField().setSpan(
                    foregroundColorSpan,
                    index,
                    index + textPattern.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
    }
}

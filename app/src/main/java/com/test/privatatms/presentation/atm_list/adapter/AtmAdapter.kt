package com.test.privatatms.presentation.atm_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.privatatms.R
import com.test.privatatms.model.Atm
import kotlinx.android.synthetic.main.item_atm.view.*

class AtmAdapter(
    private val data: MutableList<Atm>,
    private val onItemClick: (atm: Atm) -> Unit,
    private val onItemFavoriteClick: (atm: Atm) -> Unit
) : RecyclerView.Adapter<AtmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtmViewHolder {
        return AtmViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_atm, parent, false)
        ).apply {
            itemView.setOnClickListener {
                onItemClick.invoke(data[adapterPosition])
            }
            itemView.atmFavouriteImageView.setOnClickListener {
                onItemFavoriteClick.invoke(data[adapterPosition])
                notifyItemChanged(adapterPosition, adapterPosition)
            }
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AtmViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun onBindViewHolder(
        holder: AtmViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if(payloads.isNotEmpty()) {
            holder.rebind(data[position])
        }else {
            holder.bind(data[position])
        }
    }

    fun swapData(newData: List<Atm>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
}
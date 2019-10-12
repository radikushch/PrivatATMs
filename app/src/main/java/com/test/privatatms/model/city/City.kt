package com.test.privatatms.model.city

import android.text.Spannable
import android.text.SpannableString
import androidx.room.Ignore
import com.test.privatatms.consts.ViewTypeConsts
import com.test.privatatms.presentation.adapter.model.SearchItem

data class City(
    val name: String
) : SearchItem {

    @Ignore
    private val searchField: Spannable = SpannableString(name)

    override fun getSearchField(): Spannable  = searchField

    override fun getViewType(): Int = ViewTypeConsts.CITY_VIEW_TYPE
}
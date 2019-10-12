package com.test.privatatms.model.city

import android.text.Spannable
import android.text.SpannableString
import androidx.room.*
import com.test.privatatms.consts.ViewTypeConsts
import com.test.privatatms.presentation.adapter.model.SearchItem

@Entity(tableName = "cities", indices = [Index(value = ["name"], unique = true)])
data class City(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name= "name") val name: String
) : SearchItem {

    @Ignore
    private val searchField: Spannable = SpannableString(name)

    override fun getSearchField(): Spannable  = searchField

    override fun getViewType(): Int = ViewTypeConsts.CITY_VIEW_TYPE
}
package com.test.privatatms.model.atm

import android.text.Spannable
import android.text.SpannableString
import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.test.privatatms.consts.ViewTypeConsts
import com.test.privatatms.presentation.adapter.model.SearchItem

@Entity(tableName = "atms")
data class Atm(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "type")
    @SerializedName("type")
    val type: String,
    @ColumnInfo(name = "cityRU")
    @SerializedName("cityRU")
    val cityRU: String,
    @ColumnInfo(name = "fullAddressRu")
    @SerializedName("fullAddressRu")
    val fullAddressRu: String,
    @ColumnInfo(name = "latitude")
    @SerializedName("latitude")
    val latitude: Double,
    @ColumnInfo(name = "longitude")
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("tw")
    @Embedded
    val tw: WorkSchedule,
    @ColumnInfo(name = "isFavourite")
    var isFavourite: Boolean = false
): SearchItem {

    @Ignore
    private val searchField: Spannable = SpannableString(fullAddressRu)

    override fun getSearchField(): Spannable = searchField

    override fun getViewType(): Int = ViewTypeConsts.ATM_VIEW_TYPE
}


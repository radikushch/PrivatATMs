package com.test.privatatms.model.atm

import android.text.Spannable
import android.text.SpannableString
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.test.privatatms.consts.ViewTypeConsts
import com.test.privatatms.presentation.adapter.model.SearchItem

data class Atm(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @SerializedName("type")
    val type: String,
    @SerializedName("cityRU")
    val cityRU: String,
    @SerializedName("fullAddressRu")
    val fullAddressRu: String,
    @SerializedName("placeRU")
    val placeRU: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("tw")
    val tw: WorkSchedule,
    var isFavourite: Boolean = false
): SearchItem {

    @Ignore
    private val searchField: Spannable = SpannableString(fullAddressRu)

    override fun getSearchField(): Spannable = searchField

    override fun getViewType(): Int = ViewTypeConsts.ATM_VIEW_TYPE

}


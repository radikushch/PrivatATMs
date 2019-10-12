package com.test.privatatms.presentation.adapter.model

import android.text.Spannable

interface SearchItem : ListItem {

    fun getSearchField(): Spannable
}
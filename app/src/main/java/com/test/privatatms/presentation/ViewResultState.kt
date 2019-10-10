package com.test.privatatms.presentation

data class ViewResultState<T>(
    val isSuccess: Boolean,
    val data: T? = null,
    val error: Int? = null
)
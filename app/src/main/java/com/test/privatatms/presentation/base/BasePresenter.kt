package com.test.privatatms.presentation.base

import com.test.privatatms.presentation.MvpContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter:  MvpContract.MvpPresenter, CoroutineScope {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext = Dispatchers.IO + job

    override fun destroy() {
        job.cancelChildren()
    }
}
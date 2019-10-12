package com.test.privatatms.presentation.atm_list

import com.test.privatatms.R
import com.test.privatatms.data.ApiResult
import com.test.privatatms.data.respository.AtmRepository
import com.test.privatatms.model.atm.Atm
import com.test.privatatms.presentation.ViewResultState
import com.test.privatatms.presentation.base.BasePresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AtmsPresenter @Inject constructor(
    private val atmListView: AtmListContract.AtmListView,
    private val atmRepository: AtmRepository
): BasePresenter(), AtmListContract.AtmListPresenter {

    override fun loadAtmList(city: String) {
        atmListView.showLoading()
        launch {
            val viewResultState: ViewResultState<List<Atm>>
            val result = atmRepository.getAtms(city)
            viewResultState = if(result is ApiResult.Success) {
                ViewResultState(isSuccess = true, data = result.data)
            }else {
                ViewResultState(isSuccess = false, error = R.string.loading_error)
            }
            withContext(Dispatchers.Main) {
                atmListView.swapAtmList(viewResultState)
                atmListView.hideLoading()
            }
        }
    }

    override fun makeAtmFavorite(atm: Atm) {
        //todo
        atm.isFavourite = !atm.isFavourite
    }
}
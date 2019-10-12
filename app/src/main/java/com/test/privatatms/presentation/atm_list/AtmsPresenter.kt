package com.test.privatatms.presentation.atm_list

import android.content.res.Resources
import com.test.privatatms.R
import com.test.privatatms.data.ApiResult
import com.test.privatatms.data.respository.AtmRepository
import com.test.privatatms.model.atm.Atm
import com.test.privatatms.model.city.City
import com.test.privatatms.presentation.ViewResultState
import com.test.privatatms.presentation.base.BasePresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class AtmsPresenter @Inject constructor(
    private val atmListView: AtmListContract.AtmListView,
    private val atmRepository: AtmRepository
): BasePresenter(), AtmListContract.AtmListPresenter {

    override fun loadAtmList(city: City) {
        atmListView.showLoading()
        launch {
            val viewResultState: ViewResultState<List<Atm>>
            val result = atmRepository.getAtms(city.name)
            viewResultState = when (result) {
                is ApiResult.Success -> ViewResultState(isSuccess = true, data = result.data)
                is ApiResult.Error -> when(result.exception) {
                    is Resources.NotFoundException -> ViewResultState(isSuccess = false, error = R.string.empty_result)
                    is TimeoutException -> ViewResultState(isSuccess = false, error = R.string.no_internet)
                    else -> ViewResultState(isSuccess = false, error = R.string.loading_error)
                }
            }
            withContext(Dispatchers.Main) {
                atmListView.swapAtmList(viewResultState)
                atmListView.hideLoading()
            }
        }
    }

    override fun makeAtmFavorite(atm: Atm) {
        atm.isFavourite = !atm.isFavourite
        launch {
            atmRepository.updateAtm(atm)
        }
    }

    override fun loadFavouritesAtms() {
        atmListView.showLoading()
        launch {
            val atms = atmRepository.getFavoritesAtms()
            withContext(Dispatchers.Main) {
                atmListView.hideLoading()
                atmListView.swapAtmList(ViewResultState(isSuccess = true, data = atms))
            }
        }
    }
}
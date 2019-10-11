package com.test.privatatms.presentation.atm_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.privatatms.R
import com.test.privatatms.data.ApiResult
import com.test.privatatms.data.AtmRepository
import com.test.privatatms.model.Atm
import com.test.privatatms.presentation.ViewResultState
import com.test.privatatms.presentation.base.BasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class AtmListPresenterImpl @Inject constructor(
    private val atmListView: AtmListContract.AtmListView,
    private val atmRepository: AtmRepository
): BasePresenter(), AtmListContract.AtmListPresenter {

    private val _atmsListLiveData = MutableLiveData<ViewResultState<List<Atm>>>()

    override fun getAtmList(city: String): LiveData<ViewResultState<List<Atm>>> {
        launch {
            val result = atmRepository.getAtms(city)
            if(result is ApiResult.Success) {
                val viewResultState = ViewResultState(isSuccess = true, data = result.data)
                _atmsListLiveData.postValue(viewResultState)
            }else {
                val viewResultState = ViewResultState<List<Atm>>(isSuccess = false, error = R.string.loading_error)
                _atmsListLiveData.postValue(viewResultState)
            }
        }
        return _atmsListLiveData
    }

    override fun makeAtmFavorite(atm: Atm) {
        atm.isFavourite = !atm.isFavourite
    }
}
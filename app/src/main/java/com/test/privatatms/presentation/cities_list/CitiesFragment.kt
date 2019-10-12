package com.test.privatatms.presentation.cities_list

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.privatatms.R
import com.test.privatatms.extensions.visible
import com.test.privatatms.model.city.City
import com.test.privatatms.presentation.adapter.SearchAdapter
import com.test.privatatms.presentation.base.BaseDialogFragment
import kotlinx.android.synthetic.main.fragment_cities_list.*
import javax.inject.Inject

class CitiesFragment : BaseDialogFragment(), CityListContract.CityListView{

    interface OnSearchClickListener {
        fun onSearchClick(city: City)
    }

    private var onSearchClickListener: OnSearchClickListener? = null

    private val spanHighlight: ForegroundColorSpan by lazy {
        ForegroundColorSpan(
            ResourcesCompat.getColor(
                resources,
                R.color.colorPrimary,
                null
            )
        )
    }

    private val citiesAdapter: SearchAdapter by lazy {
        SearchAdapter(
            foregroundColorSpan = spanHighlight,
            onItemClick = {citySearchEditText.setText((it as City).name) }
        )
    }

    @Inject
    lateinit var citiesPresenter: CitiesPresenter

    override fun setupCitiesList(cities: List<City>) {
        if(cities.isEmpty()) return
        citiesListRecyclerView.visible()
        citiesAdapter.swapData(cities)
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun layout(): Int = R.layout.fragment_cities_list

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(parentFragment is OnSearchClickListener){
            onSearchClickListener = parentFragment as OnSearchClickListener
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        citiesPresenter.loadUkrainianCities()
        citySearchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                citiesAdapter.search(s.toString())
            }
        })
        citySearchAcceptTextView.setOnClickListener {
            onSearchClickListener?.onSearchClick(City(name = citySearchEditText.text.toString()))
            dismissAllowingStateLoss()
        }
    }

    private fun setupRecyclerView() {
        citiesListRecyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.VERTICAL,
            false
        )
        citiesListRecyclerView.adapter = citiesAdapter
        citiesListRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                (citiesListRecyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
    }
}
package com.test.privatatms.presentation.atm_list

import android.os.Bundle
import android.text.style.ForegroundColorSpan
import android.view.View
import com.test.privatatms.R
import com.test.privatatms.presentation.base.BaseFragment
import javax.inject.Inject
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.privatatms.extensions.invisible
import com.test.privatatms.extensions.visible
import com.test.privatatms.model.atm.Atm
import com.test.privatatms.model.city.City
import com.test.privatatms.presentation.ViewResultState
import com.test.privatatms.presentation.adapter.SearchAdapter
import com.test.privatatms.presentation.cities_list.CitiesFragment
import kotlinx.android.synthetic.main.fragment_atm_list.*

class AtmsFragment : BaseFragment(), AtmListContract.AtmListView, CitiesFragment.OnSearchClickListener {


    @Inject
    lateinit var atmListPresenter: AtmsPresenter

    private val spanHighlight: ForegroundColorSpan by lazy {
        ForegroundColorSpan(
            ResourcesCompat.getColor(
                resources,
                R.color.colorAccent,
                null
            )
        )
    }

    private val atmAdapter: SearchAdapter by lazy {
        SearchAdapter(ArrayList(),
            {
                openAtmDetailScreen()
            },
            {
                atmFavoriteClick(it as Atm)
            },
            spanHighlight)
    }

    private fun atmFavoriteClick(atm: Atm) {
        atmListPresenter.makeAtmFavorite(atm)
    }

    private fun openAtmDetailScreen() {
        //todo
    }

    override fun layout(): Int = R.layout.fragment_atm_list

    override fun destroyPresenter() {
        atmListPresenter.destroy()
    }

    override fun showLoading() {
        loadingProgressBar.visible()
    }

    override fun hideLoading() {
        loadingProgressBar.invisible()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        openCitiesFragmentChooser()
        scrollTopFAB.setOnClickListener { atmsRecyclerView.scrollToPosition(0) }
        cityImageView.setOnClickListener {
            openCitiesFragmentChooser()
        }
    }

    private fun openCitiesFragmentChooser() {
        CitiesFragment().show(childFragmentManager, "tag")
    }

    override fun swapAtmList(viewResultState: ViewResultState<List<Atm>>) {
        if (viewResultState.isSuccess) {
            viewResultState.data?.let {
                atmAdapter.swapData(it)
            }
        } else {
            Toast.makeText(
                requireContext(),
                getString(viewResultState.error!!),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun setupRecyclerView() {
        atmsRecyclerView.adapter = atmAdapter
        atmsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        atmsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > dy * 0.3) {
                    scrollTopFAB.hide()
                } else if (dy < dy * 0.3) {
                    scrollTopFAB.show()
                }
            }
        })
    }

    override fun onSearchClick(city: City) {
        atmListPresenter.loadAtmList(city)
    }
}

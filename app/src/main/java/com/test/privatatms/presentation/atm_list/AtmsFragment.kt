package com.test.privatatms.presentation.atm_list

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.view.View
import com.test.privatatms.R
import com.test.privatatms.presentation.base.BaseFragment
import javax.inject.Inject
import android.widget.Toast
import androidx.core.content.ContextCompat
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

    private var selectedCity: City? = null
    private var isFavoriteList: Boolean = false

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
                openAtmDetailScreen(it as Atm)
            },
            {
                atmFavoriteClick(it as Atm)
            },
            spanHighlight)
    }

    private fun atmFavoriteClick(atm: Atm) {
        atmListPresenter.makeAtmFavorite(atm)
    }

    private fun openAtmDetailScreen(atm: Atm) {
        navController.navigate(AtmsFragmentDirections.actionAtmListFragmentToAtmDetailFragment(atm))
    }

    override fun layout(): Int = R.layout.fragment_atm_list

    override fun destroyPresenter() {
        atmListPresenter.destroy()
    }

    override fun showLoading() {
        atmsRecyclerView.invisible()
        loadingProgressBar.visible()
    }

    override fun hideLoading() {
        atmsRecyclerView.visible()
        loadingProgressBar.invisible()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openCitiesFragmentChooser()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        scrollTopFAB.setOnClickListener {
            atmsRecyclerView.scrollToPosition(0)
        }
        cityImageView.setOnClickListener {
            openCitiesFragmentChooser()
        }
        atmSearchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                atmAdapter.search(p0.toString())
            }
        })
        favoritesImageView.setOnClickListener {
            onFavoriteListClick()
        }
    }

    private fun onFavoriteListClick() {
        if(isFavoriteList) {
            favoritesImageView.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_favorite_border))
            isFavoriteList = false
            atmListPresenter.loadAtmList(selectedCity ?: City(name = ""))
        }else {
            favoritesImageView.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_favorite))
            isFavoriteList = true
            atmListPresenter.loadFavouritesAtms()
        }
        atmListPresenter.loadFavouritesAtms()
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
            atmAdapter.swapData(emptyList())
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
        selectedCity = city
        atmListPresenter.loadAtmList(city)
    }
}

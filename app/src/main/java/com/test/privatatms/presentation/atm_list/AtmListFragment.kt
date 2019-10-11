package com.test.privatatms.presentation.atm_list

import android.os.Bundle
import android.view.View
import com.test.privatatms.R
import com.test.privatatms.presentation.base.BaseFragment
import javax.inject.Inject
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.privatatms.extensions.invisible
import com.test.privatatms.extensions.visible
import com.test.privatatms.model.Atm
import com.test.privatatms.presentation.atm_list.adapter.AtmAdapter
import kotlinx.android.synthetic.main.fragment_atm_list.*

class AtmListFragment : BaseFragment(), AtmListContract.AtmListView {

    @Inject
    lateinit var atmListPresenter: AtmListPresenterImpl

    private val atmAdapter: AtmAdapter by lazy {
        AtmAdapter(ArrayList(),
            {
                openAtmDetailScreen()
            },
            {
                atmFavoriteClick(it)
            })
    }

    private fun atmFavoriteClick(atm: Atm) {
        atmListPresenter.makeAtmFavorite(atm)
    }

    private fun openAtmDetailScreen() {

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
        scrollTopFAB.setOnClickListener { atmsRecyclerView.scrollToPosition(0) }
        showLoading()
        atmListPresenter.getAtmList("Киев").observe(this, Observer { viewResultState ->
            hideLoading()
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
        })
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
}

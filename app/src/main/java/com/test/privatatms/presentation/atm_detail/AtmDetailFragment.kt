package com.test.privatatms.presentation.atm_detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.test.privatatms.R
import com.test.privatatms.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_atm_detail.*
import javax.inject.Inject
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback

class AtmDetailFragment : BaseFragment(), AtmDetailContract.AtmDetailView, OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    @Inject lateinit var atmDetailPresenter: AtmDetailPresenter

    private val args by navArgs<AtmDetailFragmentArgs>()

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun layout(): Int = R.layout.fragment_atm_detail

    override fun destroyPresenter() {
        atmDetailPresenter.destroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayWorkSchedule()
        mapView.onCreate(null)
        mapView.onResume()
        mapView.getMapAsync(this)
    }

    private fun displayWorkSchedule() {
        val atm = args.atm
        atmWorkScheduleTextView.text = atm.tw.toString()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        MapsInitializer.initialize(requireContext())
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        val atm = args.atm
        val sydney = LatLng(atm.latitude, atm.longitude)
        mMap.addMarker(MarkerOptions().position(sydney).title("ATM"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15f))
        mMap.animateCamera(CameraUpdateFactory.zoomIn())
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15F), 2000, null)
    }
}
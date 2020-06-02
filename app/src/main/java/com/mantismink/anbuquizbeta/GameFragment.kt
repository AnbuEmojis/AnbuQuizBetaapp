package com.mantismink.anbuquizbeta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    lateinit var mAdView : AdView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val layout =inflater.inflate(R.layout.fragment_game, container, false)

        val item = ArrayList<AdClass>()

        item.add(AdClass("Ad"))

        val recycler = layout.findViewById<RecyclerView>(R.id.adRView)

        val adapter = AdclassAdapter(item , activity!!.applicationContext)

        recycler.layoutManager = GridLayoutManager(activity!!.applicationContext , 1)

        recycler.adapter = adapter


        mAdView = layout.findViewById(R.id.adRView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        return layout
    }
}
package com.mantismink.anbuquizbeta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class AESFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val layout= inflater.inflate(R.layout.fragment_a_e_s, container, false)

        val item = ArrayList<StoreClass>()

        item.add(StoreClass("Anbu!?Bag" , R.drawable.bag2))
        item.add(StoreClass("Anbu!?Bag" , R.drawable.lsae))
        item.add(StoreClass("Anbu!?Bag" , R.drawable.ltt2))
        item.add(StoreClass("Anbu!?Bag" , R.drawable.ltt))

        val recycler = layout.findViewById<RecyclerView>(R.id.aESFrag)

        val adapter = StoreAdapter(item , activity!!.applicationContext)

        recycler.layoutManager = GridLayoutManager(activity!!.applicationContext , 1)

        recycler.adapter = adapter

        return layout
    }

}

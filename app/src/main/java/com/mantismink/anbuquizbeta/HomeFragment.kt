package com.mantismink.anbuquizbeta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val layout =inflater.inflate(R.layout.fragment_home, container, false)

        val item = ArrayList<PostClass>()

        item.add(PostClass("Follow us on Facebook" , R.drawable.aes , "Please don't forget to like and follow us on Facebook. Let us know how you like 'Anbu!?Quiz'"))

        val recycler = layout.findViewById<RecyclerView>(R.id.postView)

        val adapter = PostAdapter(item , activity!!.applicationContext)

        recycler.layoutManager = GridLayoutManager(activity!!.applicationContext , 1)

        recycler.adapter = adapter

        return layout
    }
}

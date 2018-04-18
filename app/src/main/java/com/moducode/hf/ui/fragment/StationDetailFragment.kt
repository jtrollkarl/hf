package com.moducode.hf.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.moducode.hf.R
import com.moducode.hf.data.Program
import kotlinx.android.synthetic.main.fragment_station_detail.*


class StationDetailFragment : Fragment() {

    companion object {
        const val PROGRAM_KEY: String = "program_key"

        fun newInstance(program: Program?): StationDetailFragment {
            val b = Bundle()
            b.putParcelable(PROGRAM_KEY, program)

            val fragment = StationDetailFragment()
            fragment.arguments = b
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_station_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val program: Program? = arguments?.getParcelable(PROGRAM_KEY)

        tv_station_name.text = program?.description
    }
}

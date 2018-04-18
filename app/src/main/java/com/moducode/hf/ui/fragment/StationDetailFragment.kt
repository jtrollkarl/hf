package com.moducode.hf.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.moducode.hf.R
import com.moducode.hf.data.Program
import com.moducode.hf.toDp
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

        tv_station_name.text = context?.getString(R.string.station_name, program?.name)
        tv_station_email.text = context?.getString(R.string.station_email, program?.email)
        tv_station_channel.text = context?.getString(R.string.station_channel, program?.channel?.id.toString())
        
        Glide.with(view.context).applyDefaultRequestOptions(RequestOptions().fitCenter()).load(program?.programimagetemplate).into(iv_program_image)
    }
}

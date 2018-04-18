package com.moducode.hf.ui.activity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.moducode.hf.R
import com.moducode.hf.data.Program
import com.moducode.hf.doTransaction
import com.moducode.hf.ui.fragment.StationDetailFragment
import com.moducode.hf.ui.fragment.StationFragment
import kotlinx.android.synthetic.main.activity_main_twopane.*

class MasterDetailActivity : SingleFragmentActivity(), StationFragment.Callbacks {

    override val fragment: Fragment
        get() = StationFragment()

    override fun getLayoutResId(): Int = R.layout.activity_masterdetail


    override fun onProgramSelected(program: Program) {
        if (fragment_detail_container == null) {
            val i = ProgramDetailActivity.newIntent(this, program)
            startActivity(i)
        } else {
            val detailFragment = StationDetailFragment.newInstance(program)

            supportFragmentManager.doTransaction {
                replace(R.id.fragment_detail_container, detailFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            }

        }
    }


}
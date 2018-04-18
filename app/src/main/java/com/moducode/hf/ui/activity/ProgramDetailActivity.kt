package com.moducode.hf.ui.activity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.moducode.hf.R
import com.moducode.hf.data.Program
import com.moducode.hf.doTransaction
import com.moducode.hf.ui.fragment.StationDetailFragment

class ProgramDetailActivity : AppCompatActivity() {



    companion object {
        fun newIntent(c: Context, program: Program): Intent{
            val i = Intent(c, ProgramDetailActivity::class.java)
            i.putExtra(StationDetailFragment.PROGRAM_KEY, program)
            return i
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        val program: Program? = intent.getParcelableExtra(StationDetailFragment.PROGRAM_KEY)

        val fragment = StationDetailFragment.newInstance(program)

        val savedFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (savedFragment == null) {
            supportFragmentManager.doTransaction { replace(R.id.fragment_container, fragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            }
        }
    }

}

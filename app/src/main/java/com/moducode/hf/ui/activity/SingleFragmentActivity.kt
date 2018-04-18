package com.moducode.hf.ui.activity

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.moducode.hf.R
import com.moducode.hf.doTransaction

abstract class SingleFragmentActivity : AppCompatActivity() {

    protected abstract val fragment: Fragment

    @LayoutRes
    protected open fun getLayoutResId(): Int = R.layout.activity_main_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())

        setupFragment()
    }

    private fun setupFragment() {
        val savedFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (savedFragment == null) {
            supportFragmentManager.doTransaction { replace(R.id.fragment_container, fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            }
        }
    }
}
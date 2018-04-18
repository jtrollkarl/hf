package com.moducode.hf.ui.fragment

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import com.moducode.hf.data.Program

interface StationFragmentContract {

    interface View : MvpLceView<List<Program>>{
        fun programClicked(program: Program)
    }

    interface Actions : MvpPresenter<View> {
        fun fetchPrograms(pullToRefresh: Boolean)
        fun handleProgramClick(program: Program)
    }

}
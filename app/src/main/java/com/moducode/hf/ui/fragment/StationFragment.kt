package com.moducode.hf.ui.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.MvpLceViewStateFragment
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.data.RetainingLceViewState

import com.moducode.hf.R
import com.moducode.hf.dagger.DaggerPresenterComponent
import com.moducode.hf.dagger.SchedulerModule
import com.moducode.hf.data.Program
import com.moducode.hf.schedulers.SchedulersImpl
import com.moducode.hf.ui.ProgramsRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_station.*
import timber.log.Timber


class StationFragment : MvpLceViewStateFragment<SwipeRefreshLayout, List<Program>, StationFragmentContract.View, StationFragmentContract.Actions>(),
        StationFragmentContract.View,
        SwipeRefreshLayout.OnRefreshListener {

    interface Callbacks {
        fun onProgramSelected(program: Program)
    }

    private lateinit var adapter: ProgramsRecyclerAdapter
    private lateinit var listener: Callbacks


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as Callbacks
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_station, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contentView.setOnRefreshListener(this)

        adapter = ProgramsRecyclerAdapter { presenter.handleProgramClick(it)}

        val layoutManager = LinearLayoutManager(context)
        recycler_programs.layoutManager = layoutManager
        recycler_programs.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
        recycler_programs.adapter = adapter

    }

    override fun loadData(pullToRefresh: Boolean) {
        presenter.fetchPrograms(pullToRefresh)
    }

    override fun onRefresh() {
        Timber.d("Refreshing list")
        loadData(true)
    }

    override fun showContent() {
        super.showContent()
        contentView.isRefreshing = false
    }

    override fun createPresenter(): StationFragmentContract.Actions {
        val component = DaggerPresenterComponent
                .builder()
                .schedulerModule(SchedulerModule(SchedulersImpl()))
                .build()

        val presenter = ProgramsPresenter()
        component.inject(presenter)
        return presenter
    }

    override fun createViewState(): LceViewState<List<Program>, StationFragmentContract.View> = RetainingLceViewState()

    override fun setData(data: List<Program>) {
        adapter.data = data
        adapter.notifyDataSetChanged()
    }

    override fun getData(): List<Program> = adapter.data

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String? {
        Timber.e(e)
        return e?.message
    }

    override fun programClicked(program: Program) {
        listener?.onProgramSelected(program)
    }
}

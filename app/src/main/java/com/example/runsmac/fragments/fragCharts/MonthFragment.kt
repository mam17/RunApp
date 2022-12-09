package com.example.runsmac.fragments.fragCharts

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.runsmac.R
import com.example.runsmac.customerviews.SetupChart
import com.example.runsmac.databinding.FragmentMonthBinding
import com.example.runsmac.utils.Utils
import com.example.runsmac.viewmodel.HomeViewModel
import com.github.mikephil.charting.data.BarEntry

class MonthFragment : Fragment() {

    private lateinit var mBinding: FragmentMonthBinding
    private lateinit var viewModel: HomeViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentMonthBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
//        viewModel.getStepsByMonth()
        observerComponent()
        return mBinding.root
    }

    private fun observerComponent() {
        viewModel.dataChartByMonth.observe(viewLifecycleOwner) {
            displayChart(it.lsAxis, it.lsBarEntry)
        }
    }

    private fun displayChart(
        lsAxis: ArrayList<String>,
        lsBarEntries: ArrayList<BarEntry>
    ) {
        SetupChart(context, mBinding.barChart, lsBarEntries, lsAxis, Utils.MAX_MONTH.toFloat())
            .applyOptions()
    }


}
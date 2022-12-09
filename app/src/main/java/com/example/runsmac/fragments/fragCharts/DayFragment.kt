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
import com.example.runsmac.databinding.FragmentDayBinding
import com.example.runsmac.utils.Utils
import com.example.runsmac.viewmodel.HomeViewModel
import com.github.mikephil.charting.data.BarEntry
import java.util.ArrayList

const val TAG = "DayFragment"

class DayFragment : Fragment() {

    private lateinit var mBinding: FragmentDayBinding
    private lateinit var viewModel: HomeViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDayBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        observerChart()
        return mBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun observerChart() {
        viewModel.dataChartByWeek.observe(viewLifecycleOwner) {
            displayChart(it.lsAxis, it.lsBarEntry)
        }
//        viewModel.isSignIn.observe(viewLifecycleOwner) {
//            if (it) {
//                viewModel.getStepsByDayOfWeek()
//            }
//        }
    }

    private fun displayChart(lsAxis: ArrayList<String>, lsBarEntries: ArrayList<BarEntry>) {
        SetupChart(context, mBinding.barChart, lsBarEntries, lsAxis, Utils.MAX_DAY.toFloat())
            .applyOptions()
    }

}
package com.example.colanlmt.view.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colanlmt.R
import com.example.colanlmt.adapters.SummaryAdapter
import com.example.colanlmt.databinding.FragmentSummaryBinding
import com.example.colanlmt.model.SummaryData

class SummaryFragment : Fragment() {
//    var _binding:FragmentSummaryBinding?=null
//    val binding get()=_binding
    lateinit var summaryAdapter: SummaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentSummaryBinding.inflate(inflater, container, false)

        binding.toolbarTitle.btnBack.setOnClickListener {
            startActivity(Intent(requireContext(),HomeActivity::class.java))
        }
        binding.toolbarTitle.titleId.text="Summary"

        val list= listOf<SummaryData>(
            SummaryData("Casual Leave",0,0,0,0),
            SummaryData("Sick Leave",0,0,0,0),
            SummaryData("Earned Leave",0,0,0,0),
            SummaryData("Loss of Pay",0,0,0,0),
            SummaryData("Comp Off",0,0,0,0),
            SummaryData("Work from Home",0,0,0,0),
            SummaryData("OnSite/Client",0,0,0,0),
        )
        summaryAdapter= SummaryAdapter(list)
        binding?.recyclerViewSummary?.layoutManager=LinearLayoutManager(context)
        binding?.recyclerViewSummary?.adapter=summaryAdapter
        summaryAdapter.notifyDataSetChanged()


        return binding.root
    }


}
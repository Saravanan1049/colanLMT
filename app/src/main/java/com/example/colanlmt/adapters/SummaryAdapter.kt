package com.example.colanlmt.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.colanlmt.databinding.SummaryRecyclerviewDataBinding
import com.example.colanlmt.model.SummaryData

class SummaryAdapter(val summaryData:List<SummaryData>):RecyclerView.Adapter<SummaryAdapter.SummaryViewHolder>() {
    class SummaryViewHolder(val binding:SummaryRecyclerviewDataBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryViewHolder {
        val binding=SummaryRecyclerviewDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SummaryViewHolder((binding))
    }

    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        with(holder){
            with(summaryData[position]){
                binding.leaveTitle.text=this.leaveType
                binding.leaveType1.text=this.actual.toString()
                binding.leaveType2.text=this.applied.toString()
                binding.leaveType3.text=this.approved.toString()
                binding.leaveType4.text=this.balance.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return summaryData.size
    }
}
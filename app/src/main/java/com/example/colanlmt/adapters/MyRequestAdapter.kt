package com.example.colanlmt.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.colanlmt.BR
import com.example.colanlmt.model.MyRequestData
import com.example.colanlmt.R
import com.example.colanlmt.databinding.MyRequestDataBinding

class MyRequestAdapter(
    private val requestData:ArrayList<MyRequestData>,
    val click:ClickMyRequest
    ):RecyclerView.Adapter<MyRequestAdapter.RequestViewHolder>() {

    fun deleteItem(i:Int){
        requestData.removeAt(i)
        notifyDataSetChanged()
    }

    fun addItem(i:Int,value:MyRequestData){
        requestData.add(i,value)
        notifyDataSetChanged()
    }

    class RequestViewHolder(val binding: MyRequestDataBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(adapter:Any){

            binding.setVariable(BR.item,adapter)
        }


//        val leaveType: MaterialTextView = view.findViewById(R.id.request_leave_type)
//        val leaveDate: MaterialTextView = view.findViewById(R.id.request_leaveDate)
//        val leaveReason: MaterialTextView = view.findViewById(R.id.request_reason)
//        val requestStatus: MaterialTextView = view.findViewById(R.id.request_status)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {

        val view:MyRequestDataBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.my_request_data,parent,false)
        return RequestViewHolder(view)

    }

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        holder.bind(requestData[position])
        holder.itemView.rootView.setOnClickListener {
            click.clickToNext(position)
        }


    }

    override fun getItemCount(): Int {
        return requestData.size
    }
}
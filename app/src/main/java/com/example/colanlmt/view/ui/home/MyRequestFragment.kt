package com.example.colanlmt.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colanlmt.model.MyRequestData
import com.example.colanlmt.R
import com.example.colanlmt.adapters.ClickMyRequest
import com.example.colanlmt.adapters.MyRequestAdapter
import com.example.colanlmt.adapters.SwipingGesture
import com.example.colanlmt.databinding.FragmentMyRequestBinding
import com.example.colanlmt.view.ui.RequestStatusFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar


class MyRequestFragment : Fragment(),ClickMyRequest {
    lateinit var requestFragment: MyRequestAdapter

//    private var _binding:FragmentMyRequestBinding?=null
//    private val binding get() = _binding
    lateinit var binding: FragmentMyRequestBinding

    private lateinit var bottomSheet:BottomSheetDialogFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentMyRequestBinding.inflate(inflater, container, false)

        binding.fabAddRequest.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_summary, AddRequestFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.appbar.titleId.text="My Request"
        binding.appbar.btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_summary,SummaryFragment())
                .addToBackStack(null)
                .commit()
        }


        initRecyclerView()

        val spinnerMain=resources.getStringArray(R.array.content)
        val spinnerAdapter=ArrayAdapter(requireContext(),R.layout.drop_down_menu,spinnerMain)
        binding.requestType.setAdapter(spinnerAdapter)



        binding.btnFilter.setOnClickListener {
            bottomSheet= BottomSheetFragment()
            bottomSheet.show(parentFragmentManager, BottomSheetFragment.TAG)

        }


        return binding.root
    }

    private fun initRecyclerView() {



        val data= arrayListOf<MyRequestData>(
            MyRequestData("Earned Leave","Jun 10,2021","Personal Work","Approved"),
            MyRequestData("Floating Leave","Feb 14,2021","Personal Work","Pending"),
            MyRequestData("Earned Leave","Jan 18,2021","Personal Work","Rejected")
        )
        requestFragment= MyRequestAdapter(data,this)
        binding.recyclerviewSummary.layoutManager =LinearLayoutManager(context)
        binding.recyclerviewSummary.adapter=requestFragment
        binding.recyclerviewSummary.setHasFixedSize(true)

        val swipe=object : SwipingGesture(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when(direction){
                    ItemTouchHelper.LEFT->{
                        requestFragment.deleteItem(viewHolder.bindingAdapterPosition)

                        Snackbar
                            .make(
                            requireView(),
                            "Deleted",
                            Snackbar.LENGTH_SHORT)
                            .setAction(
                                "Undo",
                                View.OnClickListener {
                                    requestFragment.addItem(viewHolder.bindingAdapterPosition,data[viewHolder.bindingAdapterPosition])
//                                    requestFragment.notifyItemInserted(viewHolder.bindingAdapterPosition)
                                        Toast.makeText(requireContext(), "undo success", Toast.LENGTH_SHORT).show()
                                })
                            .show()

                        Toast.makeText(requireContext(), "Deleted", Toast.LENGTH_SHORT).show()
                    }
                    ItemTouchHelper.RIGHT->{
//                        val  archiveItem=data[viewHolder.bindingAdapterPosition]
//                        requestFragment.addItem(viewHolder.bindingAdapterPosition,archiveItem)
                        Toast.makeText(requireContext(), "Archived", Toast.LENGTH_SHORT).show()
                        requestFragment.notifyDataSetChanged()
                    }
                }
            }
        }
//        val touchHelper=ItemTouchHelper(swipe)
//        touchHelper.attachToRecyclerView(binding?.recyclerviewSummary)

    }

    override fun clickToNext(position: Int) {
        Toast.makeText(context, "this is $position", Toast.LENGTH_SHORT).show()
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_summary,RequestStatusFragment())
            .addToBackStack(null)
            .commit()
    }

}
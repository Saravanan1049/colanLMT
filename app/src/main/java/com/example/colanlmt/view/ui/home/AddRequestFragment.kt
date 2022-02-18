package com.example.colanlmt.view.ui.home

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.colanlmt.R
import com.example.colanlmt.databinding.AddRequestBinding
import java.util.*

class AddRequestFragment : Fragment() {

//    var _binding: AddRequestBinding? = null
//    val binding get() = _binding!!
    lateinit var binding: AddRequestBinding

    lateinit var myCalendar: Calendar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddRequestBinding.inflate(inflater, container, false)

        binding.toolbarTitle.btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_summary,MyRequestFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.toolbarTitle.titleId.text="Add Request"

        //request type
        val itemsRequestType = resources.getStringArray(R.array.leave_request)
        val adapterRequest =
            ArrayAdapter(requireContext(), R.layout.drop_down_menu, itemsRequestType)
        binding.requestType.setAdapter(adapterRequest)
        (binding.requestType).setOnItemClickListener { adapterView, view, position, long ->
            when (position) {
                0 -> {
                    Toast.makeText(
                        context,
                        "Clicked $position is leave request",
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.leaveRequest.visibility=View.VISIBLE

                    binding.txtReasonText.visibility=View.VISIBLE
                    binding.textReasonLayout.visibility=View.VISIBLE
                    binding.contactNo.visibility=View.VISIBLE
                    binding.countryCodeLayout.visibility=View.VISIBLE

                    binding.permissionLayout.visibility=View.GONE




                }
                1 -> {
                    Toast.makeText(context, "Clicked $position Permission", Toast.LENGTH_LONG)
                        .show()
                    binding.leaveRequest.visibility=View.GONE

                    binding.txtReasonText.visibility=View.VISIBLE
                    binding.textReasonLayout.visibility=View.VISIBLE
                    binding.contactNo.visibility=View.VISIBLE
                    binding.countryCodeLayout.visibility=View.VISIBLE


                    binding.permissionLayout.visibility=View.VISIBLE
                }
                2 -> {
                    Toast.makeText(context, "Clicked $position Work from Home", Toast.LENGTH_LONG)
                        .show()

                    binding.leaveRequest.visibility=View.VISIBLE

                    binding.txtReasonText.visibility=View.VISIBLE
                    binding.textReasonLayout.visibility=View.VISIBLE
                    binding.contactNo.visibility=View.VISIBLE
                    binding.countryCodeLayout.visibility=View.VISIBLE

                    binding.leaveTypeLayout.visibility=View.GONE
                    binding.leaveTypeText.visibility=View.GONE
                    binding.permissionLayout.visibility=View.GONE

                }
            }
        }



        //leave_type
        val itemsLeaveType = resources.getStringArray(R.array.leave_type_list)
        val adapterLeave = ArrayAdapter(requireContext(), R.layout.drop_down_menu, itemsLeaveType)
        binding.leaveType.setAdapter(adapterLeave)
        (binding.leaveType).setOnItemClickListener { adapterView, view, position, long ->
            when (position) {
                0 -> {
                    Toast.makeText(context, "Clicked $position", Toast.LENGTH_SHORT).show()

                }
                1 -> {
                    Toast.makeText(context, "Clicked $position", Toast.LENGTH_LONG).show()
                }
                2 -> {
                    Toast.makeText(context, "Clicked $position", Toast.LENGTH_LONG).show()
                }
            }

        }



        //duration

        val itemsDuration = resources.getStringArray(R.array.duration_list)
        val adapterDuration = ArrayAdapter(requireContext(), R.layout.drop_down_menu, itemsDuration)
        binding.duration.setAdapter(adapterDuration)
        (binding.duration).setOnItemClickListener { adapterView, view, position, long ->
            when (position) {
                0 -> {
                    Toast.makeText(context, "Clicked $position", Toast.LENGTH_SHORT).show()
                    binding.dateTillPicker.visibility=View.GONE
                    binding.dateTillLayout.visibility = View.GONE
                }
                1 -> {
                    Toast.makeText(context, "Clicked $position", Toast.LENGTH_LONG).show()
                    binding.dateTillPicker.visibility=View.VISIBLE
                    binding.dateTillLayout.visibility = View.VISIBLE
                }


//            Toast.makeText(context, "Clicked $position", Toast.LENGTH_SHORT).show()
            }
        }

        myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        binding.dateLayout.setOnClickListener {
            val datePickerFrom = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { datePicker, dYear, dMonth, dDate ->
                    binding.dateFromText.text = "$dDate/${dMonth + 1}/$dYear"
                },
                year,
                month,
                day
            )
            datePickerFrom.show()
        }

        binding.dateTillLayout.setOnClickListener {
            val datePickerFrom = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { datePicker, dYear, dMonth, dDate ->
                    binding.dateTillText.text = "$dDate/${dMonth + 1}/$dYear"
                },
                year,
                month,
                day
            )
            datePickerFrom.show()
        }


        binding.btnReset.setOnClickListener {
            binding.requestType.clearListSelection()
            binding.leaveType.clearListSelection()
            binding.duration.clearListSelection()
            binding.dateFromText.text = ""
            binding.dateTillText.text = ""
            binding.textReason.text?.clear()
            binding.contactNumber.text?.clear()
        }


        binding.sessionContent.setOnCheckedChangeListener { radioGroup, checked ->
            when(checked){
                R.id.morning->{
                    val timeFrom = resources.getStringArray(R.array.date_from_entries_morning)
                    val adapterDateFrom = ArrayAdapter(requireContext(), R.layout.drop_down_menu, timeFrom)
                    binding.timeFromText.setAdapter(adapterDateFrom)
                }
                R.id.afternoon->{
                    val timeFrom = resources.getStringArray(R.array.date_from_entries_afternoon)
                    val adapterDateFrom = ArrayAdapter(requireContext(), R.layout.drop_down_menu, timeFrom)
                    binding.timeFromText.setAdapter(adapterDateFrom)
                }
            }
        }

        binding.permissionDateLayout.setOnClickListener {
            val datePickerFrom = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { datePicker, dYear, dMonth, dDate ->
                    binding.permissionDateText.text = "$dDate/${dMonth + 1}/$dYear"
                },
                year,
                month,
                day
            )
            datePickerFrom.show()
        }

        val timeTill = resources.getStringArray(R.array.time_till_entry)
        val adapterDateFrom = ArrayAdapter(requireContext(), R.layout.drop_down_menu, timeTill)
        binding.timeTillText.setAdapter(adapterDateFrom)
        (binding.timeTillText).setOnItemClickListener { adapterView, view, position, long ->
            when (position){
                0->{

                }
            }
        }

//        binding.totalTimeText.text=binding.timeFromText+1

//        binding.workingOnLayout.setOnClickListener {
//            val datePickerFrom = DatePickerDialog(
//                requireContext(),
//                DatePickerDialog.OnDateSetListener { datePicker, dYear, dMonth, dDate ->
//                    binding.workingOnText.text = "$dDate/${dMonth + 1}/$dYear"
//                },
//                year,
//                month,
//                day
//            )
//            datePickerFrom.show()
//        }
//
//        val inTime = resources.getStringArray(R.array.time)
//        val adapterInTime = ArrayAdapter(requireContext(), R.layout.drop_down_menu, inTime)
//        binding.inTimeText.setAdapter(adapterInTime)
//
//        val outTime = resources.getStringArray(R.array.time)
//        val adapterOutTime = ArrayAdapter(requireContext(), R.layout.drop_down_menu, outTime)
//        binding.outTimeText.setAdapter(adapterOutTime)
//
//        val reportList = resources.getStringArray(R.array.report_list)
//        val adapterReportList = ArrayAdapter(requireContext(), R.layout.drop_down_menu, reportList)
//        binding.reportingPersonText.setAdapter(adapterReportList)



        return binding.root
    }



}
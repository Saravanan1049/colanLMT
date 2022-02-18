package com.example.colanlmt.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.colanlmt.R
import com.example.colanlmt.databinding.FragmentRequestStatusBinding
import com.example.colanlmt.model.EmployeeDetailsData
import com.example.colanlmt.view.ui.home.MyRequestFragment

class RequestStatusFragment : Fragment() {
//    var _binding: FragmentRequestStatusBinding?=null
//    val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       val fragmentRequestBinding: FragmentRequestStatusBinding =DataBindingUtil.inflate(
           inflater,
           R.layout.fragment_request_status,
           container,
           false
       )

        val data=EmployeeDetailsData(
                "Saravanan",
                "CIPL1049",
                "Mobility",
                "Trainee Software Engineer",
                "Earned Leave",
                "Two Days",
                "13-feb-2022",
                "15-feb-2022",
                "Personal Work",
                "Approved",
                "Rafiudeen",
                "13-feb-2022",
                "13-feb-2022|3:20PM")

        val data1= arrayListOf<EmployeeDetailsData>(
            EmployeeDetailsData("Neeraj",
            "CIPL0988","Mobility",
                        "Trainee Software Engineer" ,
                        "Comp Off" ,
                        "One Day" ,
                        "19-feb-2022" ,
                        "20-feb-2022" ,
                        "Personal Work" ,
                        "Pending" ,
                                "Rafiudeen" ,
                                "19-feb-2022",
                                "19-feb-2022|11:00AM"),
            EmployeeDetailsData("Syed Fahad Hussain",
                "CIPL0981","Mobility",
                "Trainee Software Engineer" ,
                "Sick Leave" ,
                "One Day" ,
                "12-feb-2022" ,
                "13-feb-2022" ,
                "Health Issue" ,
                "Approved" ,
                "-" ,
                "-",
                "-"),
            EmployeeDetailsData("Ganesh",
                "CIPL0980","Mobility",
                "Trainee Software Engineer" ,
                "Casual Leave" ,
                "One Day" ,
                "22-feb-2022" ,
                "23-feb-2022" ,
                "Personal Work" ,
                "Rejected" ,
                "Rafiudeen" ,
                "19-feb-2022",
                "19-feb-2022|11:00AM"),

        )


        fragmentRequestBinding.data=data

        fragmentRequestBinding.appBar.titleId.text="My Request"
        fragmentRequestBinding.appBar.btnBack.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_summary,MyRequestFragment())
                .addToBackStack(null)
                .commit()
        }




        return fragmentRequestBinding?.root


//
//        binding?.employeeName?.text="Saravanan"
//        binding?.employeeId?.text="CIPL1049"
//        binding?.department?.text="Mobility"
//        binding?.designation?.text="Trainee Software Engineer"
//        binding?.leaveTypeStatus?.text="Earned Leave"
//        binding?.durationStatus?.text="one day"
//        binding?.requestFromStatus?.text="13-feb-2022"
//        binding?.requestToStatus?.text="15-feb-2022"
//        binding?.reason?.text="Personal Work"
//        binding?.status?.text="Approved"
//        binding?.updatedBy?.text="Rafiudeen"
//        binding?.approvedDate?.text="13-feb-2022"
//        binding?.updatedOn?.text="13-feb-2022|3:20PM"
//
//
//
//
//        return binding?.root
    }


}
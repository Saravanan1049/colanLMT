package com.example.colanlmt.view.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.colanlmt.R
import com.example.colanlmt.databinding.ProfileBinding
import com.example.colanlmt.viewmodel.ProfileViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textview.MaterialTextView
import java.util.*

class ProfileFragment : Fragment(), RadioGroup.OnCheckedChangeListener {
    lateinit var binding: ProfileBinding
    lateinit var myViewModel: ProfileViewModel
    lateinit var calendar: Calendar
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.profile, container, false)
        val view = binding.root
        myViewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)
        binding.viewModel = myViewModel

        binding.profileToolbar.titleId.text = "Profile"
        binding.profileToolbar.btnBack.setOnClickListener {
            startActivity(Intent(requireContext(), HomeActivity::class.java))
        }


        binding.physicallyChallenged.radioGroup.setOnCheckedChangeListener(this)
        binding.martialStatus.radioGroup.setOnCheckedChangeListener(this)
        binding.passportCheck.radioGroup.setOnCheckedChangeListener(this)
        binding.holdingAnyVisa.radioGroup.setOnCheckedChangeListener(this)
        binding.haveChildren.radioGroup.setOnCheckedChangeListener(this)

        setDateInTextview(binding.dateofBirth.datepickertext, "Date of Birth")
        setDateInTextview(binding.sdateofBirth.datepickertext, "Certificate DOB")
        setDateInTextview(binding.spouseDob.datepickertext, "Spouse Date of Birth")
        setDateInTextview(binding.childDob.datepickertext, " Child Date of Birth")
        increaseEditTextHeight()
        return view
    }


    private fun setDateInTextview(textview: MaterialTextView, titiletext: String) {
        calendar = Calendar.getInstance()
        val today = MaterialDatePicker.todayInUtcMilliseconds()
        val builder = MaterialDatePicker.Builder.datePicker()
        builder.setTitleText(titiletext)
        builder.setTheme(R.style.MaterialCalendarTheme)
        builder.setSelection(today)
        val materialDatePicker = builder.build()
        textview.setOnClickListener {
            materialDatePicker.show(parentFragmentManager, "DATE PICKER")
        }
        materialDatePicker.addOnPositiveButtonClickListener {
            textview.text = materialDatePicker.headerText
        }
    }


    private fun increaseEditTextHeight() {
        binding.pAddress.edittext.gravity = Gravity.TOP
        val lp1: ConstraintLayout.LayoutParams =
            binding.pAddress.edittext.layoutParams as ConstraintLayout.LayoutParams
        val lp2: ConstraintLayout.LayoutParams =
            binding.rAddress.edittext.layoutParams as ConstraintLayout.LayoutParams
        lp1.height = lp1.height * 3
        lp2.height = lp2.height * 3
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (group) {
            binding.physicallyChallenged.radioGroup -> {
                if (binding.physicallyChallenged.noRadioButton.id.equals(checkedId)) {
                    myViewModel.disability.set(false)
                    Toast.makeText(requireContext(), "$checkedId", Toast.LENGTH_SHORT).show()
                    Log.d("viewmodelValue", "viewModelValue is ${myViewModel.disability.get()}")
                }
                if (binding.physicallyChallenged.yesRadioButton.id.equals(checkedId)) {
                    myViewModel.disability.set(true)
                    Toast.makeText(requireContext(), "$checkedId", Toast.LENGTH_SHORT).show()
                    Log.d("viewmodelValue", "viewModelValue is ${myViewModel.disability.get()}")
                }

            }
            binding.martialStatus.radioGroup -> {
                if (binding.martialStatus.noRadioButton.id.equals(checkedId)) {
                    myViewModel.martialStatus.set(false)
                    myViewModel.haveChild.set(false)
                    Toast.makeText(requireContext(), "$checkedId", Toast.LENGTH_SHORT).show()
                    Log.d(
                        "viewmodelValue",
                        "viewModelValue is ${myViewModel.martialStatus.get()}"
                    )
                }

                if (binding.martialStatus.yesRadioButton.id.equals(checkedId)) {
                    myViewModel.martialStatus.set(true)
                    myViewModel.haveChild.set(true)
                    binding.haveChildren.yesRadioButton.isChecked = true
                    binding.haveChildren.noRadioButton.isChecked = false
                    Toast.makeText(requireContext(), "$checkedId", Toast.LENGTH_SHORT).show()
                    Log.d(
                        "viewmodelValue",
                        "viewModelValue is ${myViewModel.martialStatus.get()}"
                    )
                }
            }
            binding.haveChildren.radioGroup -> {
                if (binding.haveChildren.noRadioButton.id.equals(checkedId)) {
                    myViewModel.haveChild.set(false)
                    Toast.makeText(requireContext(), "hellooooo", Toast.LENGTH_SHORT).show()
                    Log.d("viewmodelValue", "viewModelValue is ${myViewModel.haveChild.get()}")
                }
                if (binding.haveChildren.yesRadioButton.id.equals(checkedId)) {
                    myViewModel.haveChild.set(true)
                }
            }
            binding.passportCheck.radioGroup -> {
                if (binding.passportCheck.noRadioButton.id.equals(checkedId)) {
                    myViewModel.passport.set(false)
                    myViewModel.visa.set(false)
                }
                if (binding.passportCheck.yesRadioButton.id.equals(checkedId)) {
                    myViewModel.passport.set(true)
                    myViewModel.visa.set(true)
                    binding.holdingAnyVisa.yesRadioButton.isChecked = true
                    binding.holdingAnyVisa.noRadioButton.isChecked = false
                }
            }
            binding.holdingAnyVisa.radioGroup -> {
                if (binding.holdingAnyVisa.noRadioButton.id.equals(checkedId)) {
                    myViewModel.visa.set(false)
                }
                if (binding.holdingAnyVisa.yesRadioButton.id.equals(checkedId)) {
                    myViewModel.visa.set(true)
                }
            }

        }
    }

}


//    val datePickerDialog = DatePickerDialog(
//        requireContext(),
//        AlertDialog.THEME_HOLO_LIGHT,
//        datePickerListener,
//        year,
//        month,
//        day
//    )
//    datePickerDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//    datePickerDialog.show()
//
//}
//
//datePickerListener =    DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
//    s= "$dayOfMonth/$month/$year"
//    textview.text = s
//}

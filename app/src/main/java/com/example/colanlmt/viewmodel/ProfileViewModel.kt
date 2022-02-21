package com.example.colanlmt.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

  // var vBoolean : MutableLiveData<Boolean> = MutableLiveData(false)

   var disability  = ObservableBoolean(false)
   var martialStatus  = ObservableBoolean(false)
   var haveChild = ObservableBoolean(false)
   var passport  = ObservableBoolean(false)
   var visa  = ObservableBoolean(false)
}
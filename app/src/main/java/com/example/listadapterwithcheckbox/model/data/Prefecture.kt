package com.example.listadapterwithcheckbox.model.data

import androidx.lifecycle.MutableLiveData

data class Prefecture(
    val name: String,
    val isChecked: MutableLiveData<Boolean> = MutableLiveData(false)
)
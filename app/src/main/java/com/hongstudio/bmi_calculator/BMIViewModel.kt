package com.hongstudio.bmi_calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class BMIViewModel : ViewModel() {

    private val _height = MutableLiveData<Int>()
    val height: LiveData<Int> get() = _height

    private val _weight = MutableLiveData<Int>()
    val weight: LiveData<Int> get() = _weight

    private val _bmi = MutableLiveData<Double>()
    val bmi: LiveData<Double> get() = _bmi

    fun calculateBmi(height: String, weight: String) {
        if (height.isEmpty() || weight.isEmpty()) {
            _bmi.value = 0.0
            return
        }
        val tmpDouble = weight.toDouble() / ((height.toDouble()/100) * (height.toDouble()/100))
        _bmi.value = (tmpDouble * 10).roundToInt() / 10.0
    }
}
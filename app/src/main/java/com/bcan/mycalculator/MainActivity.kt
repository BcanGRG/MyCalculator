package com.bcan.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var tvInput: TextView? = null
    var isLastNumeric: Boolean = false
    var isLastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvInput)
    }

    fun onDigit(view: View) {
        tvInput?.append((view as Button).text)
        isLastNumeric = true
        isLastDot = false
    }

    fun onClear(view: View) {
        tvInput?.text = ""
    }

    fun onDecimalPoint(view: View) {
        if (isLastNumeric && !isLastDot) {
            tvInput?.append(".")
            isLastNumeric = false
            isLastDot = true
        }
    }

    fun onOperator ( view: View){
        tvInput?.text?.let {
            if(isLastNumeric && !isOperatorAdded(it.toString())){
                tvInput?.append((view as Button).text)
                isLastNumeric = false
                isLastDot = false
            }
        }
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }
}
package com.loukya.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var i1: EditText
    lateinit var i2: EditText
    lateinit var resultTextView: TextView
    lateinit var add_btn: Button
    lateinit var sub_btn: Button
    lateinit var mul_btn: Button
    lateinit var div_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        i1 = findViewById(R.id.et_input1)
        i2 = findViewById(R.id.et_input2)
        resultTextView = findViewById(R.id.tv_result)
        add_btn = findViewById(R.id.btn_add)
        sub_btn = findViewById(R.id.btn_sub)
        mul_btn = findViewById(R.id.btn_mul)
        div_btn = findViewById(R.id.btn_div)

        add_btn.setOnClickListener { onClick(it) }
        sub_btn.setOnClickListener { onClick(it) }
        mul_btn.setOnClickListener { onClick(it) }
        div_btn.setOnClickListener { onClick(it) }
    }

    fun onClick(v: View?) {
      val a = i1.text.toString().toDoubleOrNull() ?: 0.0
   val b = i2.text.toString().toDoubleOrNull() ?: 0.0
        var resultValue = 0.0

        when (v?.id) {
            R.id.btn_add -> {
                resultValue = a + b
            }
            R.id.btn_sub -> {
                resultValue = a - b
            }
            R.id.btn_mul -> {
                resultValue = a * b
            }
            R.id.btn_div -> {
                if (b != 0.0) {
                    resultValue = a / b
                } else {
                    resultTextView.text = "Cannot divide by zero"
                    return
                }
            }
        }

        resultTextView.text = "Result is: $resultValue"
    }
}

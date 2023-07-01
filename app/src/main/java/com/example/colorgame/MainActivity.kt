package com.example.colorgame

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.skydoves.colorpickerview.ColorPickerView
import com.skydoves.colorpickerview.listeners.ColorListener


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorPickerView = findViewById<ColorPickerView>(R.id.colorPickerView)

        colorPickerView.setColorListener(ColorListener { color, fromUser ->
            val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
            linearLayout.setBackgroundColor(color)
        })

    }
}

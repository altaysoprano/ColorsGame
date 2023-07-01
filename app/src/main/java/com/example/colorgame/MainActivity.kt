package com.example.colorgame

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.skydoves.colorpickerview.ColorPickerView
import com.skydoves.colorpickerview.listeners.ColorListener


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorPickerView = findViewById<ColorPickerView>(R.id.colorPickerView)
        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)

        viewModel.selectedColor.observe(this, Observer { color ->
            linearLayout.setBackgroundColor(color)
        })

        colorPickerView.setColorListener(ColorListener { color, fromUser ->
            viewModel.onColorChanged(color)
        })

    }
}

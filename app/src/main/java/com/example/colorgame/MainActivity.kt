package com.example.colorgame

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.colorgame.databinding.ActivityMainBinding
import com.skydoves.colorpickerview.ColorPickerView
import com.skydoves.colorpickerview.listeners.ColorListener
import java.util.Random
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    private val random = Random()
    private val timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.colorPickerView.setColorListener(ColorListener { color, fromUser ->
            binding.linearLayout.setBackgroundColor(color)
            val red = Color.red(color)
            val green = Color.green(color)
            val blue = Color.blue(color)
            binding.colorTextView.text = "RGB: $red, $green, $blue"
        })

        binding.colorPickerView.attachBrightnessSlider(binding.brightnessSlide)

        startColorChangeTimer(binding.argbTextView)
    }

    private fun startColorChangeTimer(argbTextView: TextView) {
        val delay = 0L
        val period = 20000L

        timer.schedule(object : TimerTask() {
            override fun run() {
                val randomColor = getRandomColor()
                runOnUiThread {
                    binding.dynamicLayout.setBackgroundColor(randomColor)
                    val red = Color.red(randomColor)
                    val green = Color.green(randomColor)
                    val blue = Color.blue(randomColor)
                    argbTextView.text = "RGB: $red, $green, $blue"
                }
            }
        }, delay, period)
    }

    private fun getRandomColor(): Int {
        val alpha = 255 // Opağı tam olarak ayarla (0-255 aralığında)
        val red = random.nextInt(256)
        val green = random.nextInt(256)
        val blue = random.nextInt(256)

        return Color.argb(alpha, red, green, blue)
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }
}

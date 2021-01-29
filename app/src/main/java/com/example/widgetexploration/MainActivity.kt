package com.example.widgetexploration

import androidx.appcompat.app.AppCompatActivity
import com.example.widgetexploration.databinding.ExplorationLayoutBinding
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ExplorationLayoutBinding.inflate( layoutInflater )
    setContentView(R.layout.exploration_layout)

    binding.checkBoxTransparency.setOnCheckedChangeListener { view, isChecked ->
      if (isChecked) {
        // Set some transparency
        binding.imageView.alpha = .1f
        Log.i("Boom", "Alpha")
      }
      else {
        // Remove the transparency
        binding.imageView.alpha = 1f
        Log.i("Boom", "Alpha")
      }
    }

    binding.checkBoxTint.setOnCheckedChangeListener { _, isChecked ->
      if (isChecked) {
        // Checked so set some tint
        Log.i("Boom", "Tint")
        binding.imageView.setColorFilter(Color.argb(150, 255, 0, 0))
      }
      else {
        // No tint required
        Log.i("Boom", "Tint")
        binding.imageView.setColorFilter(Color.argb(0, 0, 0, 0))
      }
    }

    binding.checkBoxResize.setOnCheckedChangeListener { _, isChecked ->
      if (isChecked) {
        // It's checked so make bigger
        Log.i("Boom", "Size")
        binding.imageView.scaleX = 2f
        binding.imageView.scaleY = 2f
      }
      else {
        // It's not checked make regular size
        Log.i("Boom", "Tint")
        binding.imageView.scaleX = 1f
        binding.imageView.scaleY = 1f


        // Now for the radio buttons
        // Uncheck all buttons
        binding.radioGroup.clearCheck()

        binding.radioGroup.setOnCheckedChangeListener {
          group, checkedId ->
          val rb = group.findViewById<View>(checkedId) as RadioButton

          when (rb.id) {
            R.id.radioButtonLondon ->
              binding.textClock.timeZone = "Europe/London"

            R.id.radioButtonBeijing ->
              binding.textClock.timeZone = "CST6CDT"


            R.id.radioButtonNewYork ->
              binding.textClock.timeZone = "America/New_York"


            R.id.radioButtonEuropeanEmpire ->
              binding.textClock.timeZone = "Europe/Brussels"
          }
        } }
    }

  }



}
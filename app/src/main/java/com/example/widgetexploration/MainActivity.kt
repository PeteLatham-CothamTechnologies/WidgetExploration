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
    val root = binding.root
//    setContentView(R.layout.exploration_layout)
    setContentView( root )

    binding.checkBoxTransparency.setOnCheckedChangeListener { _, isChecked ->
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
        Log.i("Boom", "Size +")
        binding.imageView.scaleX = 2f
        binding.imageView.scaleY = 2f
      } else {
        // It's not checked make regular size
        Log.i("Boom", "Size -")
        binding.imageView.scaleX = 1f
        binding.imageView.scaleY = 1f
      }
    }

    // Now for the radio buttons
    // Uncheck all buttons
    binding.radioGroup.clearCheck()

    binding.radioGroup.setOnCheckedChangeListener {
      group, checkedId ->
      val rb = group.findViewById<View>(checkedId) as RadioButton

      when (rb.id) {
        R.id.radioButtonLondon -> {
          Log.i("Time", "London!")
          binding.textClock.timeZone = "Europe/London"
        }

        R.id.radioButtonBeijing -> {
          Log.i("Time", "Beijing")
          binding.textClock.timeZone = "CST6CDT"
        }

        R.id.radioButtonNewYork -> {
          Log.i("Time", "New York")
          binding.textClock.timeZone = "America/New_York"
        }

        R.id.radioButtonEuropeanEmpire -> {
          Log.i("Time", "Central Europe")
          binding.textClock.timeZone = "Europe/Brussels"
        }
      }
    }

    /*
     Let's listen for clicks on our "Capture" Button.
     The compiler has worked out that the single function
     of the required interface has a single parameter.
     Therefore, the syntax is shortened (->) is removed
     and the only parameter, (should we have needed it)
     is declared invisibly as "it"
    */
    binding.button.setOnClickListener {
      // it... accesses the view that was clicked

      // We want to act on the textView and editText instances
      // Change the text on the TextView
      // to whatever is currently in the EditText
      binding.textView.text = binding.editText.text
    }

    // Show or hide the TextView
    binding.switch1.setOnCheckedChangeListener {
      _, isChecked ->
      if (isChecked) {
        binding.textView.visibility = View.VISIBLE
      } else {
        binding.textView.visibility = View.INVISIBLE
      }
      Log.i("Boom", "Switched!")
    }
  }
}


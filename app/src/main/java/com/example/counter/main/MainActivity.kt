package com.example.counter.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.counter.databinding.ActivityMainBinding
import com.example.counter.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {

    private lateinit var binding: ActivityMainBinding
    private var presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicks()
        presenter.attachView(this)

    }

    private fun initClicks() {

        binding.incrementBtn.setOnClickListener {
            presenter.increment()
            presenter.checkCount()
        }

    }

    override fun updateActualCount(count: Int) {
        binding.counterTv.text = count.toString()
    }

    override fun checkCount(count: Int) {

        when (count) {
            10 -> Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show()
            15 -> {
                binding.counterTv.setTextColor(Color.GREEN)
                binding.incrementBtn.setBackgroundColor(Color.GREEN)
            }

        }

    }

}
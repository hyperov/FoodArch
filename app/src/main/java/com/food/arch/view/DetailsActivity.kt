package com.food.arch.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.food.arch.R
import com.food.arch.databinding.ActivityDetailsBinding
import com.food.arch.extensions.EMPLOYEE
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityDetailsBinding>(this, R.layout.activity_details)
        binding.emp = intent?.getParcelableExtra(EMPLOYEE)

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }

    }

}

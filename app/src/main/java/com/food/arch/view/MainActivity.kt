package com.food.arch.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.food.arch.R
import com.food.arch.extensions.goTo
import com.food.arch.extensions.isNetworkAvailable
import com.food.arch.extensions.showSnackBar
import com.food.arch.model.response.Employee
import com.food.arch.viewmodel.MainViewModel
import com.food.arch.viewmodel.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        mainViewModel.employeesLiveData.observe(this, Observer<List<Employee>?> {
            mainViewModel.progressLiveData.value = false
            val adapter = EmployeesAdapter(it!!) { employee -> goTo(DetailsActivity::class.java, employee) }
            rvList.adapter = adapter
        })

        mainViewModel.errorLiveData.observe(this, Observer<String?> {
            rvList.showSnackBar(getString(R.string.error_message))
        })

        mainViewModel.progressLiveData.observe(this, Observer<Boolean?> {
            progress.visibility = when (it!!) {
                true -> {
                    rvList.visibility = View.GONE
                    View.VISIBLE
                }
                false -> {
                    rvList.visibility = View.VISIBLE
                    View.GONE
                }
            }
        })

        mainViewModel.networkLiveData.value = isNetworkAvailable()
        mainViewModel.progressLiveData.value = true
        mainViewModel.getAllEmployees()


    }
}

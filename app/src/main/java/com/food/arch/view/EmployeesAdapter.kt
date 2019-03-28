package com.food.arch.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.food.arch.R
import com.food.arch.model.remote.Apis.Companion.BASE_URL
import com.food.arch.model.response.Employee
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_employee.view.*
import java.util.*

class EmployeesAdapter(
    private val data: List<Employee> = ArrayList(),
    private val onItemClick: (employee: Employee) -> Unit
) :
    RecyclerView.Adapter<EmployeesAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount() = data.size


    inner class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(employee: Employee) = with(itemView) {

            with(employee) {
                tvEmployeeName.text = name
                Picasso.get().load(BASE_URL+imageUrl).into(ivEmployee)
            }

            setOnClickListener {
                onItemClick(employee)
            }
        }
    }
}
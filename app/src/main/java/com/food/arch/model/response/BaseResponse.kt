package com.food.arch.model.response

import com.google.gson.annotations.SerializedName

data class BaseResponse(val error: Boolean, @SerializedName("Emps") val employees: List<Employee>)

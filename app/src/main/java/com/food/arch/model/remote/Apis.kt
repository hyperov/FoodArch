package com.food.arch.model.remote

import com.food.arch.model.response.BaseResponse
import io.reactivex.Flowable
import retrofit2.http.GET


interface Apis {


    @GET("app/employee/getall")
    fun getEmployees(): Flowable<BaseResponse>


    companion object {
        const val BASE_URL = "http://alsultanh.com/soltan_service/"

    }

}
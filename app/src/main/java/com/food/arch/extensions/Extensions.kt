package com.food.arch.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.BindingAdapter
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.food.arch.R
import com.food.arch.model.remote.Apis.Companion.BASE_URL
import com.food.arch.model.response.Employee
import com.squareup.picasso.Picasso


const val EMPLOYEE = "EMPLOYEE"
fun AppCompatActivity.goTo(recieverActivity: Class<*>, employee: Employee? = null) {

    val intent = Intent(this, recieverActivity)
    employee?.let {
        val bundle = Bundle().apply { putParcelable(EMPLOYEE, employee) }
        intent.putExtras(bundle)
    }
    startActivity(intent)
}

@BindingAdapter("picassoImage")
fun setImageViewResource(imageView: ImageView, url: String) {
    Picasso.get().load(BASE_URL + url).placeholder(R.mipmap.ic_launcher).error(com.food.arch.R.mipmap.ic_launcher)
        .into(imageView)
}

fun Activity.isNetworkAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}

fun View.showSnackBar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}
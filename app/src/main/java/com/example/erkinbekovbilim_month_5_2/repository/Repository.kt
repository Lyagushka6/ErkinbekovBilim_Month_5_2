package com.example.erkinbekovbilim_month_5_2.repository

import android.net.DnsResolver.Callback
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.erkinbekovbilim_month_5_2.model.LoveModel
import com.example.erkinbekovbilim_month_5_2.service.RetrofitService
import retrofit2.Call
import retrofit2.Response

class Repository{

    fun getLove(firstName: String, secondName: String) : MutableLiveData<LoveModel>{
        var liveLove = MutableLiveData<LoveModel>()

        RetrofitService().api.percentageNames(firstName, secondName).enqueue(object :retrofit2.Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    liveLove.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}")
            }

        })

        return liveLove
    }

}
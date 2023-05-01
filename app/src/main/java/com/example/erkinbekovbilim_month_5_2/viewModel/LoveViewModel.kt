package com.example.erkinbekovbilim_month_5_2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.erkinbekovbilim_month_5_2.repository.Repository
import com.example.erkinbekovbilim_month_5_2.model.LoveModel

class LoveViewModel :ViewModel(){

    val repository = Repository()

    fun liveLove(firstName: String, secondName: String): LiveData<LoveModel>{

        return repository.getLove(firstName, secondName)
    }

}
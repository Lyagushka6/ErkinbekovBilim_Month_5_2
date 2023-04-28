package com.example.erkinbekovbilim_month_5_2.ui.calculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.erkinbekovbilim_month_5_2.R
import com.example.erkinbekovbilim_month_5_2.RetrofitService
import com.example.erkinbekovbilim_month_5_2.databinding.FragmentLoveCalculatorBinding
import com.example.erkinbekovbilim_month_5_2.model.LoveModel
import retrofit2.Call
import retrofit2.Response



class LoveCalculatorFragment : Fragment() {

    lateinit var binding: FragmentLoveCalculatorBinding

    companion object{
        const val KEY_FOR_FNAME = "firstName"
        const val KEY_FOR_SNAME = "secondName"
        const val KEY_FOR_PERCE = "123%"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoveCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loveCalculate()
    }

    private fun loveCalculate() {
        with(binding) {
            btnCalculate.setOnClickListener {
                RetrofitService().api.percentageNames(
                    firstNameEd.text.toString(),
                    secondNameEd.text.toString()
                ).enqueue(object : retrofit2.Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        findNavController().navigate(
                            R.id.loveScoreFragment, bundleOf(
                                KEY_FOR_FNAME to response.body()?.firstName,
                                KEY_FOR_SNAME to response.body()?.secondName,
                                KEY_FOR_PERCE to response.body()?.percentage,
                            )
                        )
                        firstNameEd.text?.clear()
                        secondNameEd.text?.clear()
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure: ${t.message}")
                    }
                })
            }
        }
    }
}
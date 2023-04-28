package com.example.erkinbekovbilim_month_5_2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.erkinbekovbilim_month_5_2.databinding.FragmentLoveScoreBinding

class LoveScoreFragment : Fragment() {

    lateinit var binding: FragmentLoveScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoveScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnTryAgain()
        loveScore()
    }

    private fun loveScore() {
        arguments?.apply {
            val firstName = getString(LoveCalculatorFragment.KEY_FOR_FNAME)
            val secondName = getString(LoveCalculatorFragment.KEY_FOR_SNAME)
            val score = getString(LoveCalculatorFragment.KEY_FOR_PERCE)

            binding.apply {
                tvFirstname.text = firstName
                tvSecondname.text = secondName
                tvScore.text = score
            }
        }
    }

    private fun btnTryAgain() {
        binding.apply {
            btnTryAgain.setOnClickListener{
                findNavController().navigateUp()
            }
        }
    }
}
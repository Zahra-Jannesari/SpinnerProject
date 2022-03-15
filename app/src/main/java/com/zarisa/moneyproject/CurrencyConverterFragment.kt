package com.zarisa.moneyproject

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.zarisa.moneyproject.databinding.FragmentCurrencyConverterBinding
var FirstSpinnerItem: String=""
var SecondSpinnerItem: String=""
class CurrencyConverterFragment : Fragment() {
    lateinit var binding: FragmentCurrencyConverterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentCurrencyConverterBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.exchange_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerFirst.adapter = adapter
            binding.spinnerSecond.adapter = adapter
        }
        binding.spinnerFirst.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                FirstSpinnerItem=p0?.getItemAtPosition(p2).toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        binding.spinnerSecond.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                SecondSpinnerItem=p0?.getItemAtPosition(p2).toString()
                binding.editTextNumberDecimalSecond.setText((DataBank.convertor(FirstSpinnerItem,
                    SecondSpinnerItem,binding.editTextNumberDecimalFirst.text.toString().toDoubleOrNull())).toString())
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

    }
}
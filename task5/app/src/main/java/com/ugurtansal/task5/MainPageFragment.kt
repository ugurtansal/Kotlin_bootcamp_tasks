package com.ugurtansal.task5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ugurtansal.task5.databinding.FragmentMainPageBinding
import kotlin.math.log


class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding;
    var inputs:String="0";


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding=FragmentMainPageBinding.inflate(inflater, container, false)

        binding.oneBtn.setOnClickListener {
           inputs = if (inputs == "0") "1" else inputs + "1"
            binding.resultTxt.setText(inputs)
        }
        binding.twoBtn.setOnClickListener {
            inputs = if (inputs == "0") "2" else inputs + "2"
            binding.resultTxt.setText(inputs)
        }
        binding.threeBtn.setOnClickListener {
            inputs = if (inputs == "0") "3" else inputs + "3"
            binding.resultTxt.setText(inputs)
        }
        binding.fourBtn.setOnClickListener {
            inputs = if (inputs == "0") "4" else inputs + "4"
            binding.resultTxt.setText(inputs)
        }

        binding.fiveBtn.setOnClickListener {
            inputs = if (inputs == "0") "5" else inputs + "5"
            binding.resultTxt.setText(inputs)
        }

        binding.sixBtn.setOnClickListener {
            inputs = if (inputs == "0") "6" else inputs + "6"
            binding.resultTxt.setText(inputs)
        }

        binding.sevenBtn.setOnClickListener {
            inputs = if (inputs == "0") "7" else inputs + "7"
            binding.resultTxt.setText(inputs)
        }

        binding.eightBtn.setOnClickListener {
            inputs = if (inputs == "0") "8" else inputs + "8"
            binding.resultTxt.setText(inputs)
        }

        binding.nineBtn.setOnClickListener {
            inputs = if (inputs == "0") "9" else inputs + "9"
            binding.resultTxt.setText(inputs)
        }

        binding.zeroBtn.setOnClickListener {
            inputs = if (inputs == "0") "0" else inputs + "0"
            binding.resultTxt.setText(inputs)
        }

        binding.addBtn.setOnClickListener {
            inputs += "+"
            binding.resultTxt.setText(inputs)
        }

        binding.mutipleBtn.setOnClickListener {
            inputs += "*"
            binding.resultTxt.setText(inputs)
        }

        binding.divideBtn.setOnClickListener {
            inputs += "/"
            binding.resultTxt.setText(inputs)
        }

        binding.minusBtn.setOnClickListener {
            inputs += "-"
            binding.resultTxt.setText(inputs)
        }

        binding.allClearBtn.setOnClickListener {
            inputs = "0"
            binding.resultTxt.setText(inputs)
        }

        binding.equalsBtn.setOnClickListener {
            if(inputs[inputs.length-1] == '+' || inputs[inputs.length-1] == '-' || inputs[inputs.length-1] == '*' || inputs[inputs.length-1] == '/'){
                inputs = inputs.substring(0,inputs.length-1)
            }

            inputs = evaluate(inputs).toString();
            binding.resultTxt.setText(inputs)
        }

        return binding.root
    }


    fun evaluate(expression: String): Int {
        val tokens = Regex("(\\d+(\\.\\d+)?|[+\\-*/])").findAll(expression).map { it.value }.toList();

        val numbers = mutableListOf<Int>()
        val operators = mutableListOf<String>()

        var i = 0
        while (i < tokens.size) {
            val token = tokens[i]
            if (token.matches(Regex("-?\\d+(\\.\\d+)?"))) {
                numbers.add(token.toInt())
            } else {
                operators.add(token)
            }
            i++
        }


        var index = 0
        while (index < operators.size) {
            when (operators[index]) {
                "*" -> {
                    val result = numbers[index] * numbers[index + 1]
                    numbers[index] = result
                    numbers.removeAt(index + 1)
                    operators.removeAt(index)
                }
                "/" -> {
                    val result = numbers[index] / numbers[index + 1]
                    numbers[index] = result
                    numbers.removeAt(index + 1)
                    operators.removeAt(index)
                }
                else -> index++
            }
        }


        var result = numbers[0]
        for (i in operators.indices) {
            when (operators[i]) {
                "+" -> result += numbers[i + 1]
                "-" -> result -= numbers[i + 1]
            }
        }

        return result
    }






}
package com.hongstudio.bmi_calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.hongstudio.bmi_calculator.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_start.*

class MainFragment : Fragment() {

    private val sharedViewModel: BMIViewModel by activityViewModels()

    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentMainBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            mainFragment = this@MainFragment
        }

        button_next.setOnClickListener {
            val heightString = editText_height.text.toString()
            val weightString = editText_weight.text.toString()
            
            if (heightString.isEmpty() || weightString.isEmpty()) {
                Toast.makeText(context, getString(R.string.toast_please_fill_in_the_blank), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            sharedViewModel.calculateBmi(heightString, weightString)
            findNavController().navigate(R.id.action_mainFragment_to_resultFragment)
        }
    }


}
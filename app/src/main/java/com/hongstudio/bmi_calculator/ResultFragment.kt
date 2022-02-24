package com.hongstudio.bmi_calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.hongstudio.bmi_calculator.databinding.FragmentMainBinding
import com.hongstudio.bmi_calculator.databinding.FragmentResultBinding
import kotlinx.android.synthetic.main.fragment_main.*

class ResultFragment : Fragment() {

    private val sharedViewModel: BMIViewModel by activityViewModels()

    private var binding: FragmentResultBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentResultBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            resultFragment = this@ResultFragment
        }
    }
}
package com.learning.lab_2_var_10.ui.main

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.learning.lab_2_var_10.R

class DisplayFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        val displayTextView: TextView = view.findViewById(R.id.displayTextView)

        viewModel.data.observe(viewLifecycleOwner) { data ->
            displayTextView.text = data
        }

        viewModel.fontSize.observe(viewLifecycleOwner) { fontSize ->
            displayTextView.textSize = fontSize
        }
    }


    companion object {
        fun newInstance() = DisplayFragment()
    }
}
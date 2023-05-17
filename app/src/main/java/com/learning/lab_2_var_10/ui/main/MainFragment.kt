package com.learning.lab_2_var_10.ui.main

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.learning.lab_2_var_10.R

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val fontSizeRadioGroup: RadioGroup = view.findViewById(R.id.fontSizeRadioGroup)
        val okButton: Button = view.findViewById(R.id.okButton)
        val cancelButton: Button = view.findViewById(R.id.cancelButton)
        val resultTextView: TextView = view.findViewById(R.id.resultTextView)
        val inputEditText: EditText = view.findViewById(R.id.inputEditText)

        okButton.setOnClickListener {
            val selectedFontSizeId = fontSizeRadioGroup.checkedRadioButtonId

            if (selectedFontSizeId != -1) {
                val selectedFontSize: RadioButton = view.findViewById(selectedFontSizeId)

                val fontSize = when(selectedFontSize.text.toString()) {
                    "Small" -> 14f
                    "Medium" -> 18f
                    "Large" -> 22f
                    else -> 18f
                }

                resultTextView.textSize = fontSize
                resultTextView.text = inputEditText.text.toString()
            } else {
                resultTextView.text = getString(R.string.error_message)
            }
        }

        cancelButton.setOnClickListener {
            fontSizeRadioGroup.clearCheck()
            inputEditText.text.clear()
            resultTextView.text = ""
        }
    }


    companion object {
        fun newInstance() = MainFragment()
    }
}
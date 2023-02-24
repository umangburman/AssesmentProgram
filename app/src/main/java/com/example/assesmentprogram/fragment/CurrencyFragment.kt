package com.example.assesmentprogram.fragment

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.assesmentprogram.R
import com.example.assesmentprogram.databinding.FragmentCurrencyBinding

class CurrencyFragment : Fragment() {

    private var binding: FragmentCurrencyBinding? = null
    private var resultList = ArrayList<String>()
    private lateinit var notesList: List<Int>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnCalculate?.setOnClickListener {
            val value = binding?.txtValue?.editText?.text.toString().trim().toIntOrNull() ?: 0
            if (value >= 10) calculate(value)
            else {
                Toast.makeText(requireContext(), getString(R.string.value_must_be_more_than_10),
                    Toast.LENGTH_LONG).show()
                dismissKeypad()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    /**
     * Calculates the minimum number of notes required to represent the given input value
     * using the available notes.
     * @param inputValue The value to calculate the notes for.
     */
    private fun calculate(inputValue: Int) {
        resultList = ArrayList()
        notesList = listOf(2000, 500, 200, 100, 50, 20, 10)
        var tempNotes = inputValue

        for (item in notesList) {
            val notes = tempNotes / item
            if (notes > 0) {
                resultList.add("$item Notes : $notes")
                tempNotes -= notes * item
            }
        }

        val resultData = resultList.joinToString("\n")
        binding?.lblResult?.text = resultData
        dismissKeypad()
    }

    /**
     * Dismisses the soft keyboard if it's currently visible.
     */
    private fun dismissKeypad() {
        try {
            val imm = requireActivity().getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(requireActivity().currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            Log.v("ERROR","Exception $e")
        }
    }
}
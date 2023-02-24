package com.example.assesmentprogram.fragment

import android.graphics.drawable.GradientDrawable.Orientation
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assesmentprogram.adapter.CheckBoxAdapter
import com.example.assesmentprogram.databinding.FragmentCheckboxBinding

class CheckboxFragment : Fragment() {

    private var binding: FragmentCheckboxBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCheckboxBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun displayRecyclerView() {
        val adapterCheckBox = CheckBoxAdapter()
        binding?.recyclerView?.apply {
            adapter = adapterCheckBox
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(
                DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            )
            setHasFixedSize(true)
        }
    }
}
package com.example.assesmentprogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assesmentprogram.adapter.PagerAdapter
import com.example.assesmentprogram.databinding.ActivityMainBinding
import com.example.assesmentprogram.fragment.CheckboxFragment
import com.example.assesmentprogram.fragment.CurrencyFragment

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val fragmentPagerAdapter = PagerAdapter(supportFragmentManager)
        fragmentPagerAdapter.addFragmentInPager(CurrencyFragment(),
            getString(R.string.fragment_currency))
        fragmentPagerAdapter.addFragmentInPager(CheckboxFragment(),
            getString(R.string.fragment_checkbox))

        binding?.viewPager?.adapter = fragmentPagerAdapter
        binding?.tabLayout?.setupWithViewPager(binding?.viewPager)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
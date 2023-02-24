package com.example.assesmentprogram.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * A PagerAdapter for displaying a list of Fragments in a ViewPager.
 * @param fragmentManager The FragmentManager to use for managing the Fragments.
 */
class PagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()

    /**
     * Returns the number of Fragments in the adapter.
     * @return The number of Fragments.
    */
    override fun getCount(): Int {
        return fragmentList.size
    }

    /**
     * Returns the Fragment at the specified position.
     * @param position The position of the Fragment to retrieve.
     * @return The Fragment at the specified position.
     */
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    /**
     * Returns the title of the Fragment at the specified position.
     * @param position The position of the Fragment.
     * @return The title of the Fragment at the specified position.
     */
    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }

    /**
     * Adds a Fragment and its title to the adapter.
     * @param fragment The Fragment to add to the adapter.
     * @param title The title of the Fragment.
     */
    fun addFragmentInPager(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }
}
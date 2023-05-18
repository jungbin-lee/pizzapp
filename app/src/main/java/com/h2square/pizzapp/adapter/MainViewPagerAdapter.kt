package com.h2square.pizzapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.h2square.pizzapp.fragments.ChickenStoreListFragment
import com.h2square.pizzapp.fragments.PizzaStoreListFragment

class MainViewPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0->"피자가게"
            else->"치킨가게"
        }
    }
    override fun getItem(position: Int): Fragment {
        return when(position){

            0-> PizzaStoreListFragment()
            else->ChickenStoreListFragment()
        }
    }

    override fun getCount(): Int {
     return 2
    }
}
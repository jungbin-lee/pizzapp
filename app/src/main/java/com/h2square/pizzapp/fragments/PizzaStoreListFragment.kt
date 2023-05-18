package com.h2square.pizzapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.h2square.pizzapp.R
import com.h2square.pizzapp.ViewStoreDetailActivity
import com.h2square.pizzapp.adapter.PizzaStoreAdapter
import com.h2square.pizzapp.datas.Store
import kotlinx.android.synthetic.main.fragment_pizza_store_list.*
import java.util.*

class PizzaStoreListFragment:Fragment() {
    val mPizzaDataList= ArrayList<Store>()

    lateinit var mPiizaStoreAdapter:PizzaStoreAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pizza_store_list,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mPizzaDataList.add(Store("A피자","1111-22222","https://cdn3.iconfinder.com/data/icons/street-food-and-food-trucker-1/64/pizza-fast-food-bake-bread-128.png"))
        mPizzaDataList.add(Store("B피자","3333-4444","https://cdn1.iconfinder.com/data/icons/cartoon-snack/128/pizza-128.png"))
        mPizzaDataList.add(Store("C피자","5555-6666","https://cdn3.iconfinder.com/data/icons/food-set-3/91/Food_C219-128.png"))
        mPizzaDataList.add(Store("D피자","7777-8888","https://cdn0.iconfinder.com/data/icons/fastfood-31/64/pizza-italian-food-fast-fastfood-cheese-piece-128.png"))
        mPizzaDataList.add(Store("안유진피자","ive-izone","https://thumb.mtstarnews.com/06/2023/04/2023041517354946468_1.jpg/dims/optimize"))

        mPiizaStoreAdapter= PizzaStoreAdapter(requireContext(),R.layout.pizza_store_list,mPizzaDataList)
        pizzaStoreListView.adapter=mPiizaStoreAdapter

        pizzaStoreListView.setOnItemClickListener { parent, view, position, id ->

            val  clickedStore = mPizzaDataList[position]
            val  myIntent= Intent(requireContext(),ViewStoreDetailActivity::class.java)
            myIntent.putExtra("storeData",clickedStore)
            startActivity(myIntent)
        }
    }
}
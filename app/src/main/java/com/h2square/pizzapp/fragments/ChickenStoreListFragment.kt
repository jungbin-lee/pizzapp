package com.h2square.pizzapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.h2square.pizzapp.R
import com.h2square.pizzapp.ViewStoreDetailActivity
import com.h2square.pizzapp.adapter.ChickenStoreAdapter
import com.h2square.pizzapp.adapter.PizzaStoreAdapter
import com.h2square.pizzapp.datas.Store
import kotlinx.android.synthetic.main.fragment_chicken_store_list.*
import kotlinx.android.synthetic.main.fragment_pizza_store_list.*
import java.util.*

class ChickenStoreListFragment:Fragment() {
    val mChikenDataList= ArrayList<Store>()
    lateinit var mChikenStoreAdapter: ChickenStoreAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_chicken_store_list,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mChikenDataList.add(Store("A치킨가게","1111-2222","https://cdn.mediafine.co.kr/news/photo/202304/28416_49542_4153.jpg"))
        mChikenDataList.add(Store("B치킨가게","3333-2222","https://img.tvreportcdn.de/cms-content/uploads/2022/09/18/dc56546c-71a1-4c04-b3de-e5f2299f7c7b.jpg"))
        mChikenDataList.add(Store("C치킨가게","34r5-2222","https://pickcon.co.kr/site/data/img_dir/2023/02/07/2023020780005_0.jpg"))
        mChikenDataList.add(Store("D치킨가게","323-2222","https://ssl.pstatic.net/mimgnews/image/origin/312/2023/01/03/589266.jpg"))

        mChikenStoreAdapter=ChickenStoreAdapter(requireContext(),R.layout.chicken_store_list,mChikenDataList)
       chickenStoreListView.adapter=mChikenStoreAdapter


        chickenStoreListView.setOnItemClickListener { parent, view, position, id ->

            val  clickedStore =mChikenDataList[position]
            val  myIntent= Intent(requireContext(), ViewStoreDetailActivity::class.java)
            myIntent.putExtra("storeData",clickedStore)
            startActivity(myIntent)
        }


    }
}
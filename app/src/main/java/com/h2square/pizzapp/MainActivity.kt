package com.h2square.pizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.h2square.pizzapp.adapter.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(){


    lateinit var mcpa:MainViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        //버튼클릭등 이벤트

    }

    override fun setValues() {
        //화면데이터 처리

        //뷰페이저

        mcpa=MainViewPagerAdapter(supportFragmentManager)
        mainViewPager.adapter=mcpa
        //tablayout
        mainTableLayout.setupWithViewPager(mainViewPager)
    }
}
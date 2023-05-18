package com.h2square.pizzapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.h2square.pizzapp.R
import com.h2square.pizzapp.datas.Store
import de.hdodenhof.circleimageview.CircleImageView

class PizzaStoreAdapter(val mContext: Context,
                        val resId:Int,
                        val mList:List<Store>):ArrayAdapter<Store>(mContext,resId,mList) {

                            val inflater= LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow=convertView
        if (tempRow==null){
            tempRow=inflater.inflate(R.layout.pizza_store_list,null)
        }
        val row=tempRow!!

        val data= mList[position]
        val storeNameTxt=row.findViewById<TextView>(R.id.storeName)
        val logoImg= row.findViewById<ImageView>(R.id.logoImg)
        storeNameTxt.text=data.name
        Glide.with(mContext).load(data.logoUrl).into(logoImg)


        return row
    }
}
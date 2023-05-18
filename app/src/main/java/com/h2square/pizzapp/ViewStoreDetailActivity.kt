package com.h2square.pizzapp

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.h2square.pizzapp.datas.Store
import kotlinx.android.synthetic.main.activity_view_store_detail.*

class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStoreData:Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        storePhoneCallBtn.setOnClickListener {
            val permissionListener= object :PermissionListener{
                override fun onPermissionGranted() {
                    val myUri=Uri.parse("tell${mStoreData.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL,myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "전화연결권한이 없습니다", Toast.LENGTH_SHORT).show()
                }

            }

            TedPermission.create()
                .setPermissionListener(permissionListener)
                .setDeniedMessage("전화권한이 필요합니다.[설정]에서 진행해주세요")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }
    }

    override fun setValues() {
        mStoreData= intent.getSerializableExtra("storeData")as Store

        Glide.with(mContext).load(mStoreData.logoUrl).into(storeLogoImg)


        storePhoneNumTxt.text=mStoreData.phoneNum
        storeNameTxt.text=mStoreData.name

    }
}
package com.xianchao.divider.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.xianchao.divider.DensityUtil
import com.xianchao.divider.MyHolder
import com.xianchao.divider.R
import com.xianchao.divider.divider.ListDivider
import kotlinx.android.synthetic.main.activity_list.*

class MyListActivity : AppCompatActivity() {


    var adapter = object : RecyclerView.Adapter<MyHolder>() {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
            val view = View(p0.context)
            view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200)
            view.setBackgroundColor(Color.parseColor("#FF0F0F"))
            return MyHolder(view)
        }

        override fun getItemCount(): Int {
            return 20
        }

        override fun onBindViewHolder(p0: MyHolder, p1: Int) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        rv_recyclerview.layoutManager = LinearLayoutManager(this)
        rv_recyclerview.adapter = adapter

        val listDivider = ListDivider.Builder()
            .setDividerHeight(DensityUtil.dp2px(this, 3f))
            .setDividerColor(Color.parseColor("#55000000"))
            .setLeftMargin(DensityUtil.dp2px(this, 10f))
            .setRightMargin(DensityUtil.dp2px(this, 10f))
            .build()
        rv_recyclerview.addItemDecoration(listDivider)
    }
}

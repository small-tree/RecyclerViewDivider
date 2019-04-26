package com.xianchao.divider

import android.app.Activity
import android.app.ListActivity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import com.xianchao.divider.activity.GridActivity
import com.xianchao.divider.activity.MyListActivity
import com.xianchao.divider.divider.ListDivider
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

fun Activity.extStartActivity(clazz: Class<out Activity>) {
    startActivity(Intent(this, clazz))
}

class MainActivity : AppCompatActivity() {


    var texts = mutableListOf<String>("MyListActivity", "GridActivity")
    var pages = mutableListOf(MyListActivity::class.java, GridActivity::class.java)


    var adapter = object : RecyclerView.Adapter<MyHolder>() {

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
            val textView = TextView(p0.context)
            textView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100)
            textView.gravity = Gravity.CENTER
            textView.setTextColor(Color.parseColor("#000000"))
            return MyHolder(textView)
        }

        override fun getItemCount(): Int {
            return pages.size
        }

        override fun onBindViewHolder(p0: MyHolder, p1: Int) {
            val textView = p0.itemView as TextView
            textView.text = texts[p1]
            textView.setOnClickListener {
                extStartActivity(pages[p1])
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_recyclerview.layoutManager = LinearLayoutManager(this)
        rv_recyclerview.adapter = adapter
        var listDivider = ListDivider.Builder()
            .setDividerColor(Color.parseColor("#66000000"))
            .setDividerHeight(10).build()
        rv_recyclerview.addItemDecoration(listDivider)
    }
}

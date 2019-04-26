package com.xianchao.divider

import android.support.v7.widget.RecyclerView
import android.view.View

class MyHolder : RecyclerView.ViewHolder {

    var hashMap = mutableMapOf<Int, View>()

    constructor(itemView: View) : super(itemView)

    fun <T : View> findviewById(id: Int): T {
        val get = hashMap.get(id)
        if (get != null) {
            return get as T
        } else {
            val viewById = itemView.findViewById<T>(id)
            hashMap.put(id, viewById)
            return viewById
        }
    }
}
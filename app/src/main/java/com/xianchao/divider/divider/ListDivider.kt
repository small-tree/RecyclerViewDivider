package com.xianchao.divider.divider

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup


/**
 * 默认分割线：高度为2px，颜色为灰色
 *
 * @param context
 * @param orientation 列表方向
 */
class ListDivider : RecyclerView.ItemDecoration {


    class Builder {
        var mDividerHeight = 2
        var mDividerColor = Color.parseColor("#000000")
        var mRightMargin = 0
        var mLeftMargin = 0


        fun setDividerHeight(dividerHeight: Int): Builder {
            mDividerHeight = dividerHeight
            return this
        }


        fun setDividerColor(dividerColor: Int): Builder {
            mDividerColor = dividerColor
            return this
        }

        fun setLeftMargin(leftMargin: Int): Builder {
            mLeftMargin = leftMargin
            return this
        }
        fun setLeftMarginDp(leftMargin: Int): Builder {
            mLeftMargin = leftMargin
            return this
        }

        fun setRightMargin(rightMargin: Int): Builder {
            mRightMargin = rightMargin
            return this
        }

        fun setRightMarginDp(rightMargin: Int): Builder {
            mRightMargin = rightMargin
            return this
        }

        fun build(): ListDivider {
            return ListDivider(this)
        }
    }

    private var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mDividerHeight = 2//分割线高度，默认为1px
    private var mRightMargin = 0
    private var mLeftMargin = 0

    /**
     * 自定义分割线
     *
     * @param context
     * @param orientation   列表方向
     * @param dividerHeight 分割线高度
     * @param dividerColor  分割线颜色
     */
    private constructor(dividerHeight: Int, dividerColor: Int) : super() {
        mDividerHeight = dividerHeight

        mPaint.color = dividerColor
        mPaint.style = Paint.Style.FILL
    }

    private constructor(builder: Builder) : super() {
        mDividerHeight = builder.mDividerHeight
        mLeftMargin = builder.mLeftMargin
        mRightMargin = builder.mRightMargin

        mPaint.color = builder.mDividerColor
        mPaint.style = Paint.Style.FILL

    }


    //获取分割线尺寸
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(0, 0, 0, mDividerHeight)
    }

    //绘制分割线
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        drawHorizontal(c, parent)
    }

    //绘制横向 item 分割线
    private fun drawHorizontal(canvas: Canvas, parent: RecyclerView) {
        val childSize = parent.childCount
        for (i in 0 until childSize) {
            val child = parent.getChildAt(i)
            val rect = Rect()
            rect.left = mLeftMargin
            rect.top = child.y.toInt() + child.measuredHeight
            rect.right = child.measuredWidth +
                    (child.layoutParams as RecyclerView.LayoutParams).rightMargin +
                    (child.layoutParams as RecyclerView.LayoutParams).leftMargin -
                    mRightMargin
            rect.bottom = rect.top + mDividerHeight
            canvas.drawRect(rect, mPaint)
        }
    }
}
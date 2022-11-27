package com.alexvasin.littleworld.general.ui.ect

import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class DividerLine(private val mDivider: Drawable, private var paddingHorizontal: Int = 0) :
    ItemDecoration() {
    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        for (i in 0..parent.childCount - 2) {
            val child: View = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val dividerTop: Int = child.bottom + params.bottomMargin
            val dividerBottom = dividerTop + mDivider.intrinsicHeight
            mDivider.setBounds(
                parent.paddingLeft + paddingHorizontal,
                dividerTop,
                parent.width - paddingHorizontal,
                dividerBottom
            )
            mDivider.draw(canvas)
        }
    }
}

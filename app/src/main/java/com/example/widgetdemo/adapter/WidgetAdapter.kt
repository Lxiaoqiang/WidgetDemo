package com.example.widgetdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter4.BaseMultiItemAdapter
import com.example.widgetdemo.bean.WidgetBean
import com.example.widgetdemo.corner
import com.example.widgetdemo.databinding.ItemLargeBinding
import com.example.widgetdemo.databinding.ItemMiddleBinding
import com.example.widgetdemo.databinding.ItemSmallBinding

class WidgetAdapter(data: ArrayList<WidgetBean>) : BaseMultiItemAdapter<WidgetBean>(data){

    class SmallVH(val viewBinding: ItemSmallBinding): RecyclerView.ViewHolder(viewBinding.root)
    class MiddleVH(val viewBinding: ItemMiddleBinding): RecyclerView.ViewHolder(viewBinding.root)
    class LargeVH(val viewBinding: ItemLargeBinding): RecyclerView.ViewHolder(viewBinding.root)

    init {
        addItemType(TYPE_SMALL, object :OnMultiItemAdapterListener<WidgetBean, SmallVH> {
            override fun onBind(holder: SmallVH, position: Int, item: WidgetBean?) {
                holder.viewBinding.ivImgSmall.corner(context, item?.id, 22)
            }

            override fun onCreate(context: Context, parent: ViewGroup, viewType: Int): SmallVH {
                return SmallVH(ItemSmallBinding.inflate(LayoutInflater.from(context), parent, false))
            }
        }).addItemType(TYPE_MIDDLE, object :OnMultiItemAdapterListener<WidgetBean, MiddleVH> {
            override fun onBind(holder: MiddleVH, position: Int, item: WidgetBean?) {
                holder.viewBinding.ivImgMiddle.corner(context, item?.id, 22)
            }

            override fun onCreate(context: Context, parent: ViewGroup, viewType: Int): MiddleVH {
                return MiddleVH(ItemMiddleBinding.inflate(LayoutInflater.from(context), parent, false))
            }

            override fun isFullSpanItem(itemType: Int): Boolean {
                return true
            }
        }).addItemType(TYPE_LARGE, object :OnMultiItemAdapterListener<WidgetBean, LargeVH> {
            override fun onBind(holder: LargeVH, position: Int, item: WidgetBean?) {
                holder.viewBinding.ivImgLarge.corner(context, item?.id, 22)
            }

            override fun onCreate(context: Context, parent: ViewGroup, viewType: Int): LargeVH {
                return LargeVH(ItemLargeBinding.inflate(LayoutInflater.from(context), parent, false))
            }

            override fun isFullSpanItem(itemType: Int): Boolean {
                return true
            }
        }).onItemViewType { position, list ->
            when(list[position].viewType) {
                1 -> TYPE_MIDDLE
                2 -> TYPE_LARGE
                else -> TYPE_SMALL
            }
        }
    }


    companion object {
        private val TYPE_SMALL = 1
        private val TYPE_MIDDLE = 2
        private val TYPE_LARGE = 3
    }
}
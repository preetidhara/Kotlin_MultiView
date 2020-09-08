package com.example.frontend.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.frontend.R
import kotlinx.android.synthetic.main.layout_header.view.*

class MainAdapter(private val context: Context) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEMS = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_HEADER -> {
                val view = LayoutInflater.from(context).inflate(R.layout.layout_header, parent, false)
                HeaderViewHolder(view)
            }

            TYPE_ITEMS -> {
                val view = LayoutInflater.from(context).inflate(R.layout.layout_bottom_item, parent, false)
                ItemViewHolder(view)
            }
            else -> throw IllegalArgumentException("INvalid view type")
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return TYPE_HEADER
        }

        return TYPE_ITEMS
    }


    inner class HeaderViewHolder(itemView: View): BaseViewHolder<View>(itemView) {

        init {
            val recentPurchaseAdapter = HeaderAdapter(context)
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            itemView.rvHeader.layoutManager = layoutManager
            itemView.rvHeader.adapter = recentPurchaseAdapter
        }

        override fun bind(item: View) {

        }
    }

    inner class ItemViewHolder(itemView: View): BaseViewHolder<View>(itemView) {

        override fun bind(item: View) {

        }
    }
}
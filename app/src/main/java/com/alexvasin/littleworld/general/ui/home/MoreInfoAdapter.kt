package com.alexvasin.littleworld.general.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.databinding.MoreInfoItemBinding
import com.alexvasin.littleworld.general.datamodels.ExpandableDataClass

class MoreInfoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var moreDataList: ArrayList<ExpandableDataClass> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = MoreInfoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MoreViewHolder(itemView, parent.context)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as MoreInfoAdapter.MoreViewHolder
        val currentUser = moreDataList[position]
        itemViewHolder.bind(currentUser)
    }

    override fun getItemCount(): Int {
        return moreDataList.size
    }

    inner class MoreViewHolder(
        private val binding: MoreInfoItemBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        private val header = binding.headerTitle
        private val arrowImg = binding.arrowImg
        private val infoRecyclerView = binding.moreInfoContent
        private var _adapter: PersonDataAdapter? = null
        private val infoAdapter: PersonDataAdapter get() = _adapter!!

        fun bind(moreItem: ExpandableDataClass) {
            header.text = context.getString(moreItem.headerId)
            if (moreItem.isExpandable) {
                arrowImg.setImageResource(R.drawable.arrow_up)
                infoRecyclerView.visibility = View.VISIBLE
            } else {
                arrowImg.setImageResource(R.drawable.arrow_down)
                infoRecyclerView.visibility = View.GONE
            }

            _adapter = PersonDataAdapter()
            infoRecyclerView.layoutManager = LinearLayoutManager(context)
            infoAdapter.setMoreItems(moreItem.children)
            infoRecyclerView.adapter = infoAdapter

            arrowImg.setOnClickListener {
                if (moreItem.isExpandable) {
                    infoRecyclerView.visibility = View.GONE
                    moreItem.isExpandable = false
                    arrowImg.setImageResource(R.drawable.arrow_down)
                } else {
                    infoRecyclerView.visibility = View.VISIBLE
                    moreItem.isExpandable = true
                    arrowImg.setImageResource(R.drawable.arrow_up)
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMoreItems(items: List<ExpandableDataClass>) {
        moreDataList.clear()
        moreDataList.addAll(items)
        notifyDataSetChanged()
    }
}
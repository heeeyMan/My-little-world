package com.alexvasin.littleworld.general.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.alexvasin.littleworld.databinding.PersonDataItemBinding
import com.alexvasin.littleworld.general.datamodels.PersonData

class PersonDataAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var personDataList: ArrayList<PersonData> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val itemView = PersonDataItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeViewHolder(itemView, parent.context)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val itemViewHolder = holder as HomeViewHolder
        val currentUser = personDataList[position]
        itemViewHolder.bind(currentUser)
    }

    override fun getItemCount() = personDataList.size

    inner class HomeViewHolder(
        private val binding: PersonDataItemBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(moreItem: PersonData) {
            binding.personDataField.text = context.getText(moreItem.personDataField)
            binding.personDataContent.text = moreItem.personDataContent
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMoreItems(items: ArrayList<PersonData>) {
        personDataList.clear()
        personDataList.addAll(items)
        notifyDataSetChanged()
    }
}
package com.alexvasin.littleworld.general.ui.home

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import android.widget.Toast
import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.general.datamodels.ExpandableDataClass
import com.alexvasin.littleworld.general.datamodels.PersonData

class MoreInformationAdapter(
    private val context: Context,
    private val moreInfoData: List<ExpandableDataClass>
) :
    BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return moreInfoData.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return moreInfoData[groupPosition].children.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return context.getString(moreInfoData[groupPosition].headerId)
    }

    override fun getChild(
        groupPosition: Int,
        childPosition: Int
    ): Any {
        return moreInfoData[groupPosition].children[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(
        groupPosition: Int,
        childPosition: Int
    ): Long {
        return (childPosition * groupPosition).toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(
        groupPosition: Int,
        childPosition: Int
    ): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        childPosition: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var view = convertView
        val content = getGroup(groupPosition) as String
        if (view != null) {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = layoutInflater.inflate(R.layout.home_group_name, null)
            val header = convertView?.findViewById<TextView>(R.id.group_name)
            header?.setTypeface(null, Typeface.BOLD)
            header?.text = content
            Toast.makeText(
                this.context,
                R.string.enter_something,
                Toast.LENGTH_SHORT
            ).show()
            return view
        }
        return View(context)
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var view = convertView
        val content = getChild(groupPosition, childPosition) as PersonData
        if (view != null) {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = layoutInflater.inflate(R.layout.person_data_item, null)
            val personData = convertView?.findViewById<TextView>(R.id.person_data)
            val personDataContent = convertView?.findViewById<TextView>(R.id.person_data_content)
            personData?.text = context.getString(content.personDataId)
            personDataContent?.text = content.personDataContent
            Toast.makeText(
                this.context,
                R.string.first_name,
                Toast.LENGTH_SHORT
            ).show()
            return view
        }
        return View(context)
    }

}
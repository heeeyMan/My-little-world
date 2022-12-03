package com.alexvasin.littleworld.general.ui.home

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.general.datamodels.ExpandableDataClass
import com.alexvasin.littleworld.general.datamodels.MoreInfoData

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
        return moreInfoData[groupPosition].headerId
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
        val contentId = getGroup(groupPosition) as Int
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.home_group_name, null)
        val header = view.findViewById<TextView>(R.id.group_name)
        header?.setTypeface(null, Typeface.BOLD)
        header?.text = context.getString(contentId)
        return view
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val content = getChild(groupPosition, childPosition) as MoreInfoData
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.person_data_item, null)
        val personData = view.findViewById<TextView>(R.id.person_data_field)
        val personDataContent = view.findViewById<TextView>(R.id.person_data_content)
        personData?.text = context.getString(content.fieldId)
        personDataContent?.text = content.content
        return view
    }

}
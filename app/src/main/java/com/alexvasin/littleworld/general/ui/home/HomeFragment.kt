package com.alexvasin.littleworld.general.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.databinding.FragmentHomeBinding
import com.alexvasin.littleworld.general.datamodels.ExpandableDataClass
import com.alexvasin.littleworld.general.datamodels.MoreInfoData
import com.alexvasin.littleworld.general.models.home.assembly.HomeAssembly

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var moreInfo: ExpandableListView? = null
    private var moreInfoAdapter: ExpandableListAdapter? = null
    private var _adapter: PersonDataAdapter? = null
    private val adapter: PersonDataAdapter get() = _adapter!!
    private var homeViewModel: HomeViewModel? = null

    private var data = listOf(
        ExpandableDataClass(
            R.string.general_info, listOf(
                MoreInfoData(R.string.birthday_date, "05.03.1999"),
                MoreInfoData(R.string.hometown, "Pervomaisk"),
                MoreInfoData(R.string.languages, "Russian, English"),
            )
        ),
        ExpandableDataClass(
            R.string.education, listOf(
                MoreInfoData(
                    R.string.university,
                    "N. I. Lobachevsky National Research University"
                ),
                MoreInfoData(R.string.faculty, "Radiophysics"),
                MoreInfoData(R.string.specialization, "Radiophysics"),
                MoreInfoData(
                    R.string.department,
                    "Theory of oscillations and automatic regulation"
                ),
            )
        ),
        ExpandableDataClass(
            R.string.experience, listOf(
                MoreInfoData(R.string.place, "N. I. Lobachevsky National Research University"),
                MoreInfoData(R.string.place, "SWTec"),
                MoreInfoData(R.string.place, "Central Research Institute of Burevestnik"),
            )
        ),
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = HomeAssembly().build()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _adapter = PersonDataAdapter()
        moreInfo = binding.moreInformation
        moreInfo!!.setAdapter(context?.let { MoreInformationAdapter(it.applicationContext, data) })
        val recyclerView = binding.personData
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel?.apply {
            personData.observe(viewLifecycleOwner) {
                adapter.setMoreItems(it)
            }
            moreInfoData.observe(viewLifecycleOwner) {
                moreInfoAdapter = context?.let { context ->
                    MoreInformationAdapter(
                        context.applicationContext,
                        it
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
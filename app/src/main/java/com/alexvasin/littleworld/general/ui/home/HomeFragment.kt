package com.alexvasin.littleworld.general.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexvasin.littleworld.databinding.FragmentHomeBinding
import com.alexvasin.littleworld.general.models.home.assembly.HomeAssembly

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var moreInfo: ExpandableListView? = null
    private var moreInfoAdapter: ExpandableListAdapter? = null
    private var _adapter: PersonDataAdapter? = null
    private val adapter: PersonDataAdapter get() = _adapter!!
    private var homeViewModel: HomeViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = HomeAssembly().build()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _adapter = PersonDataAdapter()
        moreInfo = binding.moreInformation
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
                moreInfo?.setAdapter(moreInfoAdapter)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        moreInfo = null
        moreInfoAdapter = null
        _adapter = null
        homeViewModel = null
    }
}
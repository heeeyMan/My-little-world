package com.alexvasin.littleworld.general.ui.home

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.databinding.FragmentHomeBinding
import com.alexvasin.littleworld.general.models.home.assembly.HomeAssembly

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var _moreInfoAdapter: MoreInfoAdapter? = null
    private val moreInfoAdapter: MoreInfoAdapter? get() = _moreInfoAdapter
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
        binding.personStatus.text = getString(R.string.status)
        binding.personStatusContent.text = getString(R.string.status_content)
        binding.icon.setImageResource(R.drawable.owner_person)
        binding.editPhoto.text = getString(R.string.edit_photo)
        binding.favoriteAnime.text = getString(R.string.favorite)
        val panda = binding.panda
        panda.setImageResource(R.drawable.panda_bear)
        val pandaToast = Toast.makeText(
            this.context,
            R.string.panda_text,
            Toast.LENGTH_SHORT
        )
        pandaToast.setGravity(Gravity.CENTER, 0, 0);
        binding.panda.setOnClickListener {
            pandaToast.show()
        }
        _adapter = PersonDataAdapter()
        val recyclerView = binding.personData
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        _moreInfoAdapter = MoreInfoAdapter()
        val moreInfo = binding.moreInformation
        moreInfo.layoutManager = LinearLayoutManager(context)
        moreInfo.adapter = moreInfoAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel?.apply {
            personData.observe(viewLifecycleOwner) {
                adapter.setMoreItems(it)
            }
            moreInfoData.observe(viewLifecycleOwner) {
                moreInfoAdapter?.setMoreItems(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _adapter = null
        homeViewModel = null
    }
}
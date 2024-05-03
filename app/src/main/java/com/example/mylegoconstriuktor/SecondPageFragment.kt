package com.example.mylegoconstriuktor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assembletheconstructoryourself.databinding.FragmentSecondPageBinding

class SecondPageFragment : Fragment() {

    private lateinit var  mainViewModel: MainViewModel
    private var _binding: FragmentSecondPageBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: LegoPartsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondPageBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = LegoPartsAdapter() // Initialize adapter
//        binding.recyclerView.adapter = adapter // Set adapter to RecyclerView

        val application = requireActivity().application as App
        val legoPartsDao = application.db.legoPartsDao()

//        mainViewModel = ViewModelProvider(this, MainViewModelFactory(legoPartsDao)).get(MainViewModel::class.java)
//
//        mainViewModel.allLegoParts.observe(viewLifecycleOwner) { legoParts ->
//            adapter.submitList(legoParts)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun Any.observe(owner: LifecycleOwner, onChanged: (List<LegoParts>?) -> Unit) {
    TODO("Not yet implemented")
}

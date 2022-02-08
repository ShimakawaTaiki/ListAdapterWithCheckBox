package com.example.listadapterwithcheckbox.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.listadapterwithcheckbox.databinding.FragmentMainBinding
import com.example.listadapterwithcheckbox.viewmodel.MainViewModel

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()
    lateinit var adapter: PrefectureListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel

        adapter = PrefectureListAdapter(viewModel, viewLifecycleOwner)
        binding.recyclerview.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.prefectures.observe(this, Observer {
            adapter.submitList(it)
        })

        viewModel.click.observe(this, Observer {
            if (viewModel.selectItem.isNotEmpty()) {
                Toast.makeText(requireActivity(), "${viewModel.selectItem.joinTo(StringBuilder())}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
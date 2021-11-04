package com.zadorotskas.lab3_5

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.zadorotskas.lab3_5.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_1, container, false)

        binding.toSecond.setOnClickListener {
            findNavController().navigate(R.id.action_1_to_2)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.to_about) {
            Navigation.findNavController(binding.root).navigate(R.id.action_about)
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}

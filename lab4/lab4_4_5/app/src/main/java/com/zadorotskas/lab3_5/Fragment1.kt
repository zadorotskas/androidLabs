package com.zadorotskas.lab3_5

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.zadorotskas.lab3_5.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: Fragment1Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_1, container, false)

        binding.bnToSecond.setOnClickListener {
            findNavController().navigate(R.id.action_1_to_2)
        }

        setHasOptionsMenu(true)
        return binding.root
    }
}

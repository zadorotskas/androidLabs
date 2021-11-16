package com.zadorotskas.lab3_5

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.zadorotskas.lab3_5.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: Fragment2Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_2, container, false)

        val navController = findNavController();

        binding.bnToFirst.setOnClickListener {
            navController.navigate(R.id.action_2_to_1)
        }

        binding.bnToThird.setOnClickListener {
            navController.navigate(R.id.action_2_to_3)
        }

        setHasOptionsMenu(true)
        return binding.root
    }
}

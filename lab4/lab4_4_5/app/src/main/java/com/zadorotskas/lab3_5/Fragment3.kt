package com.zadorotskas.lab3_5

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.zadorotskas.lab3_5.databinding.Fragment3Binding

class Fragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: Fragment3Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_3, container, false)

        val navController = findNavController()

        binding.bnToSecond.setOnClickListener {
            navController.navigate(R.id.action_3_to_2)
        }

        binding.bnToFirst.setOnClickListener {
            navController.navigate(R.id.action_3_to_1)
        }

        setHasOptionsMenu(true)
        return binding.root
    }
}

package com.bit2b.gear.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bit2b.gear.R
import com.bit2b.gear.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.usernameTV
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.cardBanner
            .findViewById<ConstraintLayout>(R.id.searchCard)
            ?.setOnClickListener {
            navigateToSearchActivity()
        }
        return root
    }

    fun navigateToSearchActivity(){
        val action = HomeFragmentDirections.actionNavigationHomeToSearchListActivity()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
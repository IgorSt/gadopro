package com.br.gadopro.view.production.insert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.br.gadopro.databinding.FragmentInsertCowBinding
import com.br.gadopro.view.production.InsertCowAdapter
import com.br.gadopro.view.production.ProductionViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class InsertCowFragment @Inject constructor() : Fragment() {

    private var _binding: FragmentInsertCowBinding? = null
    private val binding get() = _binding!!

    private val insertCowAdapter = InsertCowAdapter()
    private val viewModel: ProductionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentInsertCowBinding.inflate(inflater, container, false).also {
            _binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
            fbInsertCow.setOnClickListener {
                InsertCowFragmentDirections.actionInsertCowFragmentToProduction().also {
                    findNavController().navigate(it)
                }
            }
            rvProduction.adapter = insertCowAdapter
        }

        viewModel.allCows.observe(viewLifecycleOwner) {
            insertCowAdapter.submitList(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
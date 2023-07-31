package com.br.gadopro.view.production

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.br.gadopro.data.model.Cow
import com.br.gadopro.databinding.FragmentProductionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductionFragment : Fragment() {

    private var _binding: FragmentProductionBinding? = null
    private val binding get() = _binding!!

    private val productionViewModel: ProductionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycle.addObserver(productionViewModel)
        return FragmentProductionBinding.inflate(inflater, container, false).also {
            _binding = it
            binding.viewModel = productionViewModel
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        binding.btnSaveCow.setOnClickListener { insertCow() }
    }

    private fun insertCow() {
        val newCow = Cow(
            id = binding.idNumber.text.toString(),
            name = binding.description.text.toString()
        )

        productionViewModel.insertCow(newCow)
        findNavController().navigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
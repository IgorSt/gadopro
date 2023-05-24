package com.br.gadopro.view.login

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.br.gadopro.R
import com.br.gadopro.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentLoginBinding.inflate(inflater, container, false).also {
            _binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.guessLogin.setOnClickListener {
            showAlert()
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(requireContext())
        builder.apply {
            setTitle(R.string.login_warning)
            setMessage(R.string.login_guess_can_lost_data)
            setPositiveButton(R.string.login_continue,
                DialogInterface.OnClickListener { dialog, which ->
                    val direction = LoginFragmentDirections.actionLoginToHome()
                    findNavController().navigate(direction)
                })
            setNegativeButton(R.string.login_create_account,
                DialogInterface.OnClickListener { dialog, which ->

                })
        }
        val dialog = builder.create()
        dialog.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
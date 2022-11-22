package com.example.flybuy.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.flybuy.R
import com.example.flybuy.data.model.modelrequest.LoginRequest
import com.example.flybuy.data.util.LoadingIndicator
import com.example.flybuy.data.util.SharedPreference
import com.example.flybuy.data.util.Utils.validateLoginRequest
import com.example.flybuy.databinding.FragmentLoginBinding
import com.example.flybuy.presentation.viewmodel.LoginViewModel
import com.example.flybuy.presentation.viewmodel.RegisterViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

	val viewModel: LoginViewModel by viewModels()
	private lateinit var loginBinding: FragmentLoginBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_login, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		loginBinding = FragmentLoginBinding.bind(view)

		loginBinding.loginButton.setOnClickListener {

			val email = loginBinding.loginUsername.editableText.toString()
			val password = loginBinding.loginPassword.editableText.toString()

			val result = validateLoginRequest(email, password)

			if (result.successful) {
				loginBinding.loginProgress.loadingProgress.visibility = View.VISIBLE
				loginBinding.loginButton.isEnabled = false

				val loginRequest = LoginRequest(email, password)

				viewModel.login(loginRequest = loginRequest)

				viewModel.successful.observe(viewLifecycleOwner){ successful ->
					if (successful == true){
						loginBinding.loginProgress.loadingProgress.visibility = View.GONE
						loginBinding.loginButton.isEnabled = true
						println("DATA SENT: $loginRequest")
						findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
						viewModel.navigateToPage()
					}else if(successful == false){
						loginBinding.loginProgress.loadingProgress.visibility = View.GONE
						loginBinding.loginButton.isEnabled = true
						Snackbar.make(loginBinding.loginButton,"${viewModel.error.value}",Snackbar.LENGTH_SHORT).show()
						viewModel.navigateToPage()
					}
				}
			}
			else {
				Snackbar.make(loginBinding.loginButton,"${result.error}", Snackbar.LENGTH_SHORT).show()
			}
		}

		loginBinding.loginSignup.setOnClickListener {
			findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
		}
	}

}
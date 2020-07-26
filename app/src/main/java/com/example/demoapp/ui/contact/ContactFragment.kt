package com.example.demoapp.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.demoapp.R
import com.example.demoapp.databinding.ContactFragmentBinding
import com.example.demoapp.domain.contact.model.Contact
import com.example.demoapp.ui.BaseViewModelFragment
import kotlinx.android.synthetic.main.contact_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ContactFragment : BaseViewModelFragment<Contact>() {

    companion object {
        fun newInstance() = ContactFragment()
    }

    override val viewModel: ContactViewModel by viewModel {
        parametersOf(ContactFragmentArgs.fromBundle(requireArguments()).contact)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ContactFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.contact_fragment, container, false
        )
        val view: View = binding.root

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setTranslationZ(view, 100f)

        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}
package com.example.demoapp.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.demoapp.R
import com.example.demoapp.databinding.ContactListFragmentBinding
import com.example.demoapp.domain.contact.model.Contact
import com.example.demoapp.ui.BaseViewModelFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class ContactListFragment : BaseViewModelFragment<List<Contact>>() {

    companion object {
        fun newInstance() = ContactListFragment()
    }

    override val viewModel: ContactListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ContactListFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.contact_list_fragment, container, false
        )
        val view: View = binding.root

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.itemSelection.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                val action =
                    ContactListFragmentDirections.actionContactListFragmentToContactFragment(it)
                findNavController().navigate(action)
            }
        })

        return view
    }
}
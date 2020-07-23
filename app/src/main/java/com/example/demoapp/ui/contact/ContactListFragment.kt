package com.example.demoapp.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.demoapp.R
import com.example.demoapp.databinding.ContactListFragmentBindingImpl
import org.koin.androidx.viewmodel.ext.android.viewModel


class ContactListFragment : Fragment() {

    companion object {
        fun newInstance() = ContactListFragment()
    }

    private val viewModel: ContactListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ContactListFragmentBindingImpl = DataBindingUtil.inflate(
                inflater, R.layout.contact_list_fragment, container, false)
        val view: View = binding.root

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}
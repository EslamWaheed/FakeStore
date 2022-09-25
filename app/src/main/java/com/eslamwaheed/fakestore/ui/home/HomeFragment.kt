package com.eslamwaheed.fakestore.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import com.eslamwaheed.fakestore.adapters.ProductsAdapter
import com.eslamwaheed.fakestore.base.BaseFragment
import com.eslamwaheed.fakestore.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getProducts()
        homeViewModel.productsResponse.observe(viewLifecycleOwner) {
            binding.rvProducts.adapter = ProductsAdapter(
                it, clickAction = {
                    it?.let {

                    }

                })
        }
    }

    override fun getViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun getViewModel(): HomeViewModel {
        return homeViewModel
    }
}
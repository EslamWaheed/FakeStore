package com.eslamwaheed.fakestore.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.eslamwaheed.fakestore.base.BaseFragment
import com.eslamwaheed.fakestore.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding, DetailsViewModel>() {
    private val detailsViewModel by viewModels<DetailsViewModel>()
    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.data = args.data
    }

    override fun getViewBinding(): FragmentDetailsBinding {
        return FragmentDetailsBinding.inflate(layoutInflater)
    }

    override fun getViewModel(): DetailsViewModel {
        return detailsViewModel
    }
}
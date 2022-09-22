package com.eslamwaheed.fakestore.base

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {

    protected lateinit var binding: VB
    protected abstract fun getViewBinding(): VB
    private lateinit var viewmodel: VM
    protected abstract fun getViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.isLoading.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let {
                showLoading(it)
            }
        }

        viewmodel.showDialog.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let {
                showDialogFragment(it)
            }
        }
    }

    private fun init() {
        binding = getViewBinding()
        viewmodel = getViewModel()
    }

    private fun showDialogFragment(
        title: String? = null, message: String? = null,
        negativeBtn: String? = null, positiveBtn: String? = null,
        negativeBtnAction: ((DialogInterface, Int) -> Unit)? = null,
        positiveBtnAction: ((DialogInterface, Int) -> Unit)? = null, tag: String? = null
    ) {
        kotlin.runCatching {
            BaseDialog(
                title, message, negativeBtn, positiveBtn,
                negativeBtnAction, positiveBtnAction
            ).show(childFragmentManager, tag)
        }
    }

    private fun showLoading(isLoading: Boolean, message: String = "") {
        if (isLoading) {
            //todo show loading
        } else {
            //todo hide loading
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //todo binding = null
    }
}
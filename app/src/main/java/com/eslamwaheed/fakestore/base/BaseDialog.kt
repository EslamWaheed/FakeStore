package com.eslamwaheed.fakestore.base

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.eslamwaheed.fakestore.R

class BaseDialog(
    private val title: String?,
    private val message: String?,
    private val negativeButton: String?,
    private val positiveButton: String?,
    private val negativeButtonAction: ((DialogInterface, Int) -> Unit)?,
    private val positiveButtonAction: ((DialogInterface, Int) -> Unit)?
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        isCancelable = false
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            title?.let { title ->
                builder.setTitle(title)
            }
            builder.setMessage(message)
                .setNegativeButton(negativeButton ?: getString(R.string.ok)) { dialog, which ->
                    negativeButtonAction?.invoke(
                        dialog,
                        which
                    )
                }.apply {
                    setPositiveButton(
                        positiveButton ?: getString(R.string.retry)
                    ) { dialog, which ->
                        positiveButtonAction?.invoke(
                            dialog,
                            which
                        )
                    }
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
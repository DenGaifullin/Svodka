package com.dinislam.svodkaandroidversion


import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import java.net.URLEncoder


class DialogFeedback : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Связь с мной: ")
                .setMessage("Вкотакте: https://vk.com/one000000000s\n\nGoogle почта: dinislam91gaifullin@gmail.com")
//                .setIcon(R.drawable.ic_launcher_background)
                .setPositiveButton("Выйти") {
                        dialog, id ->  dialog.cancel()
                }.setNeutralButton("Написать в вотсапп") {
                        dialog, id -> type()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun type() {
        try {
            val packageManager = context!!.packageManager
            val i = Intent(Intent.ACTION_VIEW)
            val url =
                "https://api.whatsapp.com/send?phone=" + "+79991304386" + "&text=" + URLEncoder.encode(
                    "Ассалам алейкум, ",
                    "UTF-8"
                )
            i.setPackage("com.whatsapp")
            i.data = Uri.parse(url)
            if (i.resolveActivity(packageManager) != null) {
                context!!.startActivity(i)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}

package com.eye.cool.permission

import android.app.AlertDialog
import android.content.Context
import android.text.TextUtils

/**
 * Created by cool on 2018/4/20.
 */
internal class DefaultRationale : Rationale {
  override fun showRationale(context: Context, permissions: Array<String>, callback: ((result: Boolean) -> Unit)?) {

    val permissionNames = Permission.transformText(context, permissions)
    val message = context.getString(R.string.permission_rationale, TextUtils.join("\n", permissionNames))

    AlertDialog.Builder(context).setCancelable(false)
        .setTitle(R.string.permission_title_rationale).setMessage(message)
        .setPositiveButton(R.string.permission_allow) { _, _ -> callback?.invoke(true) }
        .setNegativeButton(R.string.permission_forbid) { _, _ -> callback?.invoke(false) }
        .show()
  }
}
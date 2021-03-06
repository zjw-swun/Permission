package com.eye.cool.permission

import android.app.AlertDialog
import android.content.Context
import android.text.TextUtils

/**
 * Created by cool on 2018/4/20.
 */
internal class SettingRationale : Rationale {

  override fun showRationale(context: Context, permissions: Array<String>, callback: ((result: Boolean) -> Unit)?) {

    val permissionNames = Permission.transformText(context, permissions)
    val message = context.getString(R.string.permission_setting_rationale,
        context.getString(R.string.app_name), TextUtils.join("\n", permissionNames))

    val settingService = PermissionSetting(context)

    AlertDialog.Builder(context)
        .setCancelable(false)
        .setTitle(R.string.permission_title_rationale)
        .setMessage(message)
        .setPositiveButton(R.string.permission_setting) { _, _ -> settingService.start() }
        .setNegativeButton(R.string.permission_no) { _, _ -> settingService.cancel() }
        .show()
  }
}
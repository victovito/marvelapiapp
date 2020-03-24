package com.victorrosa.marvelapi

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.AnimRes
import androidx.appcompat.app.AppCompatActivity
import java.math.BigInteger
import java.security.MessageDigest

fun AppCompatActivity.goToActivityWithParams(hasToFinish: Boolean, targetActivity: Class<*>, extras: Bundle) {
    goToActivityWithParamsWithAnimation(hasToFinish, targetActivity, extras, R.anim.fade_in, R.anim.fade_out)
}
fun AppCompatActivity.goToActivityWithParamsWithAnimation(hasToFinish: Boolean, targetActivity: Class<*>, extras: Bundle, @AnimRes enterAnim: Int, @AnimRes exitAnim: Int) {
    startActivity(Intent(this, targetActivity).apply { putExtras(extras) })
    onFinish(hasToFinish)
    overridePendingTransition(enterAnim, exitAnim)
}
private fun AppCompatActivity.onFinish(hasToFinish: Boolean) {
    if (hasToFinish) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition()
        } else {
            finish()
        }
    }
}

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

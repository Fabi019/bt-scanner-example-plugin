package dev.fabik.exampleplugin.protocol

import android.content.Intent

data class PluginResult(val scanId: String?, val result: Boolean, val detail: String) {
    fun toIntent(packageName: String) = Intent(Protocol.ACTION_SEND_RESULT).apply {
        setPackage(Protocol.CORE_PACKAGE)
        putExtra(Protocol.EXTRA_PROTOCOL_VERSION, Protocol.PROTOCOL_VERSION)
        putExtra(Protocol.EXTRA_PACKAGE, packageName)
        putExtra(Protocol.EXTRA_SCAN_ID, scanId)
        putExtra(Protocol.EXTRA_RESULT_OK, result)
        putExtra(Protocol.EXTRA_RESULT_DETAIL, detail)
    }
}
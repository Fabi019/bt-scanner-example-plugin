package dev.fabik.exampleplugin.protocol

import android.content.Intent

data class StatusResult(val running: Boolean, val state: Protocol.PluginState, val detail: String?) {
    fun toIntent(packageName: String): Intent = Intent(Protocol.ACTION_PLUGIN_STATUS).apply {
        setPackage(Protocol.CORE_PACKAGE)
        putExtra(Protocol.EXTRA_PROTOCOL_VERSION, Protocol.PROTOCOL_VERSION)
        putExtra(Protocol.EXTRA_PACKAGE, packageName)
        putExtra(Protocol.EXTRA_RUNNING, running)
        putExtra(Protocol.EXTRA_STATE, state.name)
        putExtra(Protocol.EXTRA_STATUS_DETAIL, detail)
    }
}
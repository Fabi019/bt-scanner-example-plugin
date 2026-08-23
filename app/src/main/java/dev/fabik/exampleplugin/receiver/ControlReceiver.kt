package dev.fabik.exampleplugin.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import dev.fabik.exampleplugin.protocol.Protocol
import dev.fabik.exampleplugin.protocol.StatusResult

class ControlReceiver : BroadcastReceiver() {
    companion object {
        private const val TAG = "ControlReceiver"
    }

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            Protocol.ACTION_PLUGIN_SET_ENABLED -> {
                val enabled = intent.getBooleanExtra(Protocol.EXTRA_ENABLED, false)
                Log.i(TAG, "Plugin was toggled, new state: $enabled")
            }

            Protocol.ACTION_PLUGIN_PING -> {
                val result = StatusResult(
                    running = true,
                    state = Protocol.PluginState.IDLE,
                    detail = "Pong!"
                )
                context.sendBroadcast(result.toIntent(context.packageName))
                Log.i(TAG, "Answered ping request!")
            }
        }
    }

}
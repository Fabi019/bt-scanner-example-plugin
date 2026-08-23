package dev.fabik.exampleplugin.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import dev.fabik.exampleplugin.protocol.BarcodeScan.Companion.toBarcodeScan
import dev.fabik.exampleplugin.protocol.PluginResult
import dev.fabik.exampleplugin.protocol.Protocol

class ScanReceiver : BroadcastReceiver() {
    companion object {
        private const val TAG = "ScanReceiver"
    }

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            Protocol.ACTION_BARCODE_SCANNED -> {
                val protocolVersion = intent.getIntExtra(Protocol.EXTRA_PROTOCOL_VERSION, 0)
                if (protocolVersion != Protocol.PROTOCOL_VERSION) {
                    Log.w(
                        TAG,
                        "Protocol version mismatch! Expected: ${Protocol.PROTOCOL_VERSION} got $protocolVersion"
                    )
                }

                val scanResult = intent.toBarcodeScan()
                Log.i(TAG, "Received scan result: $scanResult")

                val result =
                    PluginResult(scanId = scanResult?.scanId, result = true, detail = "Success!")
                context.sendBroadcast(result.toIntent(context.packageName))
            }

            else -> {
                Log.w(TAG, "Received unknown action ${intent.action}")
            }
        }
    }
}
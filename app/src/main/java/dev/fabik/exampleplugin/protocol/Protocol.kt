package dev.fabik.exampleplugin.protocol

// Directly taken from: app/src/main/java/dev/fabik/bluetoothhid/bt/ExternalProtocol.kt
object Protocol {
    const val CORE_PACKAGE = "dev.fabik.bluetoothhid"

    enum class PluginState {
        IDLE, STARTING, CONNECTING, CONNECTED, LISTENING, ERROR, BLOCKED, NO_PERMISSION, UNKNOWN;
    }

    const val PROTOCOL_VERSION = 1
    const val EXTRA_PROTOCOL_VERSION = "protocol_version"

    const val ACTION_BARCODE_SCANNED = "dev.fabik.bluetoothhid.action.BARCODE_SCANNED"
    const val ACTION_PLUGIN_SET_ENABLED = "dev.fabik.bluetoothhid.plugin.action.SET_ENABLED"
    const val ACTION_PLUGIN_PING = "dev.fabik.bluetoothhid.plugin.action.PING"
    const val ACTION_SEND_RESULT = "dev.fabik.bluetoothhid.action.SEND_RESULT"
    const val ACTION_PLUGIN_STATUS = "dev.fabik.bluetoothhid.plugin.action.STATUS"

    // ── Extras for ACTION_BARCODE_SCANNED ───────────────────────────────────────────────────
    const val EXTRA_SCAN_ID = "scan_id"
    const val EXTRA_RAW_VALUE = "raw_value"
    const val EXTRA_PROCESSED_VALUE = "processed_value"
    const val EXTRA_FORMAT = "format"
    const val EXTRA_TIMESTAMP = "timestamp"
    const val EXTRA_SOURCE = "source"
    const val EXTRA_SCANNER_ID = "scanner_id"
    const val EXTRA_REGEX_GROUPS = "regex_groups"
    const val EXTRA_IMAGE_NAME = "image_name"

    // ── Extras for ACTION_SEND_RESULT ───────────────────────────────────────────────────────
    const val EXTRA_RESULT_OK = "result_ok"
    const val EXTRA_RESULT_DETAIL = "result_detail"

    // ── Extras for ACTION_PLUGIN_SET_ENABLED ────────────────────────────────────────────────
    const val EXTRA_ENABLED = "enabled"

    // ── Extras for ACTION_PLUGIN_STATUS ─────────────────────────────────────────────────────
    const val EXTRA_PACKAGE = "package"
    const val EXTRA_RUNNING = "running"
    const val EXTRA_STATUS_DETAIL = "status_detail"
    const val EXTRA_STATE = "state"
}
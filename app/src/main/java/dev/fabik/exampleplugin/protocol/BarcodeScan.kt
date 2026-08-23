package dev.fabik.exampleplugin.protocol

import android.content.Intent

data class BarcodeScan(
    val scanId: String,
    val rawValue: String,
    val processedValue: String,
    val format: String?,    // Null for manual inputs
    val timestamp: Long,
    val source: String,
    val scannerId: String?,
    val regexGroups: Array<String>,
    val imageName: String?,
) {
    companion object {
        fun Intent.toBarcodeScan(): BarcodeScan? {
            return BarcodeScan(
                scanId = getStringExtra(Protocol.EXTRA_SCAN_ID) ?: return null,
                rawValue = getStringExtra(Protocol.EXTRA_RAW_VALUE) ?: return null,
                processedValue = getStringExtra(Protocol.EXTRA_PROCESSED_VALUE) ?: return null,
                format = getStringExtra(Protocol.EXTRA_FORMAT),
                timestamp = getLongExtra(Protocol.EXTRA_TIMESTAMP, 0),
                source = getStringExtra(Protocol.EXTRA_SOURCE) ?: return null,
                scannerId = getStringExtra(Protocol.EXTRA_SCANNER_ID),
                regexGroups = getStringArrayExtra(Protocol.EXTRA_REGEX_GROUPS) ?: emptyArray(),
                imageName = getStringExtra(Protocol.EXTRA_IMAGE_NAME),
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BarcodeScan

        if (timestamp != other.timestamp) return false
        if (scanId != other.scanId) return false
        if (rawValue != other.rawValue) return false
        if (processedValue != other.processedValue) return false
        if (format != other.format) return false
        if (source != other.source) return false
        if (scannerId != other.scannerId) return false
        if (!regexGroups.contentEquals(other.regexGroups)) return false
        if (imageName != other.imageName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = timestamp.hashCode()
        result = 31 * result + scanId.hashCode()
        result = 31 * result + rawValue.hashCode()
        result = 31 * result + processedValue.hashCode()
        result = 31 * result + format.hashCode()
        result = 31 * result + source.hashCode()
        result = 31 * result + (scannerId?.hashCode() ?: 0)
        result = 31 * result + regexGroups.contentHashCode()
        result = 31 * result + (imageName?.hashCode() ?: 0)
        return result
    }
}
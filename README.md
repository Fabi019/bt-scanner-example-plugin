# Overview

Example plugin for the [HID Barcode Scanner](https://github.com/Fabi019/hid-barcode-scanner) app.

## Metadata

Plugin name, short label and author are set in the [AndroidManifest.xml](app/src/main/AndroidManifest.xml).

## Handler

The plugin consists mainly of two event (broadcast) receivers. Inside the two receivers you can
add your custom logic. Ideally your plugin spawns one foreground service instance and the handler
then communicate with the service over intents. Otherwise Android might decide to terminate the
plugin activity at any time which could introduce delays when the plugin is started again by the
next request.

### Scan receiver

In the [ScanReceiver](app/src/main/java/dev/fabik/exampleplugin/receiver/ScanReceiver.kt) the plugin
receives a value of type [BarcodeScan](app/src/main/java/dev/fabik/exampleplugin/protocol/BarcodeScan.kt)
that contains the scanned code value, format and other values associated with the scan.

Using the `scanId` from the `BarcodeScan`, the plugin can optionally respond if the processing
was sucessfull and provide a detail string that will show as a snackbar on the scanner screen.

### Control receiver

In the [ControlReceiver](app/src/main/java/dev/fabik/exampleplugin/receiver/ControlReceiver.kt) two actions
are handled.

1. `ACTION_PLUGIN_SET_ENABLED`: This is called once on startup and when the user toggles the plugin from the "External output plugins" settings.
   Can be used to start/stop the plugin to save energy.
2. `ACTION_PLUGIN_PING`: Called by the main app once every few seconds to retrieve the current plugin status.
   The plugin can respond with the current running state and a detail message that will be shown in the "External output plugins" sheet.

## Build

Open project with Android Studio (<https://developer.android.com/studio/run>) or build the APK directly in a command line 
with (<https://developer.android.com/build/building-cmdline>):

```bash
$ gradlew assembleDebug
```

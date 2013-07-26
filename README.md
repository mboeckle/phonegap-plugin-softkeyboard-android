# PhoneGap plugin (Android-only) for use via AppGyver Steroids for showing/hiding the soft (on-screen) keyboard #

CAVEAT: Experimental - use at your own risk.

## Setup

### Cloud-side:

In your app's build settings (at https://cloud.appgyver.com/applications/<appId>), specify the following in the `Plugins` field (this example assumes that this plugin is the only one to use):

    [
      { "source":"https://github.com/mklement0/appgyver-steroids-plugin-softkeyboard-android.git" }
    ]

Note: For debugging, you can either create an ad-hoc build of your app or have a custom version of the _Scanner_ app built that includes the plugin.

### Project-side:

Place a copy of `www/softkeyboard.js` in your app project's `www` subfolder (e.g., in `www/javascripts/plugins` and reference it in your HTML files as needed; e.g.

    <script src="javascripts/plugins/softkeyboard.js"></script>

This wrapper will expose the plugin's functionality as `window.plugins.softkeyboard`

## Usage

    window.plugins.softKeyboard.show(function () {
        // success
    },function () {
       // fail
    });

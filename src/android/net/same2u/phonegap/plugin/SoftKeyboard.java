package net.same2u.phonegap.plugin.SoftKeyboardPlugin;

import org.json.JSONArray;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;

public class SoftKeyboard extends CordovaPlugin {

    public SoftKeyboard() {
    }

    public void showKeyboard() {
        InputMethodManager mgr = (InputMethodManager) cordova.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.showSoftInput(webView, InputMethodManager.SHOW_IMPLICIT);
        
        ((InputMethodManager) cordova.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(webView, 0); 
    }
    
    public void hideKeyboard() {
        InputMethodManager mgr = (InputMethodManager) cordova.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(webView.getWindowToken(), 0);
    }
    
    public boolean isKeyboardShowing() {
        
    	int heightDiff = webView.getRootView().getHeight() - webView.getHeight();
    	return (100 < heightDiff); // if more than 100 pixels, its probably a keyboard...
    }

    @Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
		if (action.equals("show")) {
            this.showKeyboard();
            callbackContext.success("done");
            return true;
		} 
        else if (action.equals("hide")) {
            this.hideKeyboard();
            callbackContext.success();
            return true;
        }
        else if (action.equals("isShowing")) {			
            callbackContext.success(Boolean.toString(this.isKeyboardShowing()));
            return true;
        }
		else {
			return false;
		}
	}    
}

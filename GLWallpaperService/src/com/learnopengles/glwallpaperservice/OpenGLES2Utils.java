package com.learnopengles.glwallpaperservice;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Build;

public abstract class OpenGLES2Utils {
	public static boolean deviceSupportsOpenGLES2(Context context) {
		ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        
        return configurationInfo.reqGlEsVersion >= 0x20000
                // Check for emulator.
                || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1
                 && (Build.FINGERPRINT.startsWith("generic")
                  || Build.FINGERPRINT.startsWith("unknown")
                  || Build.MODEL.contains("google_sdk")
                  || Build.MODEL.contains("Emulator")
                  || Build.MODEL.contains("Android SDK built for x86")));
	}
}

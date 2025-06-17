package com.hardkernel.vendor.sdk.Rtc;

import android.util.Log;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.hardkernel.vendor.sdk.Utility;

/**
 * Rtc Manager.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class RtcManager {
    private static final String TAG = "Rtc";
    private static RtcManager rtc;
    private final Object rtcManager;
    private RtcManager(Object rtc) {
        if (rtc == null) {
            Log.e(TAG, "Failed to create vendor.hardkernel.hardware.rtc.Rtc.");
            rtcManager = null;
            throw new NoSuchElementException("Init vendor.hardkernel.hardware.rtc.Rtc is failed");
        } else
            rtcManager = rtc;
    }

    /**
     * Get singleton instance for managing Rtc.
     * @return RtcManager Instance.
     */
    public static RtcManager getInstance() {
        if (rtc == null) {
            rtc = new RtcManager(Utility.getInstance(
                    "vendor.hardkernel.hardware.rtc.Rtc"));
        }
        return rtc;
    }

    /**
     * Get declared methods.
     * @return method string list.
     */
    public ArrayList<String> getDeclaredMethods() {
        if (rtcManager == null) {
            Log.e(TAG, "Not initialized.");
            throw new NoSuchElementException("No vendor.hardkernel.hardware.rtc.Rtc.");
        }
        return  Utility.getMethodList(rtcManager);
    }

    /**
     * get current rtc time.
     * @return long type rtc current time seconds.
     */
    public long getTime() {
        if (rtcManager == null) {
            Log.e(TAG, "Not initialized.");
            throw new NoSuchElementException("No vendor.hardkernel.hardware.rtc.Rtc.");
        }
        Object time =  Utility.invokeMethod(rtcManager, "getTime");
        if (time == null)
            return 0;
        else
            return (long)time;
    }

    /**
     * Set rtc wakeup alarm.
     * On odroid, no other things didn't work. just wake up when power off status.
     *
     * @param secs long type, target time. please modify getTime return values.
     * @param enable boolean type, when you want to disable it, pelase false it.
     * @return check worn nice or failed.
     */
    public boolean setRtcWakeup(long secs, boolean enable) {
        if (rtcManager == null) {
            Log.e(TAG, "Not initialized.");
            throw new NoSuchElementException("No vendor.hardkernel.hardware.rtc.Rtc.");
        }
        Object result = Utility.invokeMethod(rtcManager, "setRtcWakeup",
                new Class[] {long.class, boolean.class},
                new Object[] {secs, enable});
        if (result == null)
            return false;
        return (boolean)result;
    }
}
package com.hardkernel.vendor.sdk.Pwr;

import android.util.Log;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.hardkernel.vendor.sdk.Utility;

/**
 * Rtc Manager.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class PwrManager {
    private static final String TAG = "Pwr";
    private static PwrManager pwr;
    private final Object pwrManager;
    private PwrManager(Object pwr) {
        if (pwr == null) {
            Log.e(TAG, "Failed to create vendor.hardkernel.hardware.pwr.Pwr.");
            pwrManager = null;
            throw new NoSuchElementException("Init vendor.hardkernel.hardware.pwr.Pwr is failed");
        } else
            pwrManager = pwr;
    }

    /**
     * Get singleton instance for managing Rtc.
     * @return PwrManager Instance.
     */
    public static PwrManager getInstance() {
        if (pwr == null) {
            pwr = new PwrManager(Utility.getInstance(
                    "vendor.hardkernel.hardware.pwr.Pwr"));
        }
        return pwr;
    }

    /**
     * Get declared methods.
     * @return method string list.
     */
    public ArrayList<String> getDeclaredMethods() {
        if (pwrManager == null) {
            Log.e(TAG, "Not initialized.");
            throw new NoSuchElementException("No vendor.hardkernel.hardware.pwr.Pwr.");
        }
        return  Utility.getMethodList(pwrManager);
    }

    /**
     * Shutdown board.
     * Power off odroid.
     *
     * @param reason String type, announce shutdown reason.
     * @return check worn nice or failed.
     */
    public boolean shutdown(String reason) {
        if (pwrManager == null) {
            Log.e(TAG, "Not initialized.");
            throw new NoSuchElementException("No vendor.hardkernel.hardware.pwr.Pwr.");
        }
        Object result = Utility.invokeMethod(pwrManager, "shutdown",
                new Class[] {String.class},
                new Object[] {reason});
        if (result == null)
            return false;
        return (boolean)result;
    }
}

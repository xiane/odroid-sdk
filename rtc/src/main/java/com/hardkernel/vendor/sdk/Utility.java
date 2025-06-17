package com.hardkernel.vendor.sdk;

import android.util.Log;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Utility {
    private static final String TAG = "SdkUtility";

    public static Object getInstance(String className) {
        try {
            return Class.forName(className).getDeclaredMethod("getInstance")
                    .invoke(null);
        } catch (Exception e) {
            Log.e(TAG, "getInstance->className:" + className);
            Log.e(TAG, "getInstance->exception:" + e);
        }
        return null;
    }

    public static ArrayList<String> getMethodList(Object object) {
        Method[] methods = object.getClass().getDeclaredMethods();
        ArrayList<String> methodList = new ArrayList<>(methods.length);
        for (Method method : methods) {
            methodList.add(method.toString());
        }
        return methodList;
    }

    public static Object invokeMethod(Object object, String methodName) {
        try {
            Method method = object.getClass().getDeclaredMethod(methodName);
            method.setAccessible(true);
            return method.invoke(object);
        } catch (Exception e) {
            Log.e(TAG, "invokeMethod->methodName:" + methodName);
            Log.e(TAG, "invokeMethod->exception:" + e);
        }
        return null;
    }

    public static Object invokeMethod(Object object, String methodName,
                                      Class<?>[] paramTypes, Object[] values) {
        try {
            Method method =
                    object.getClass().getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            return method.invoke(object, values);
        } catch (Exception e) {
            Log.e(TAG, "invokeMethod->methodName:" + methodName);
            Log.e(TAG, "invokeMethod->exception:" + e);
        }
        return null;
    }
}
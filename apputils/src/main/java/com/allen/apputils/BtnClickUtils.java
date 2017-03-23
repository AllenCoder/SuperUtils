package com.allen.apputils;

public class BtnClickUtils {
    private static long mLastClickTime = 0;

    private BtnClickUtils() {

    }

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - mLastClickTime;
        if (0 < timeD && timeD < 500) {
            return true;
        }

        mLastClickTime = time;

        return false;
    }
}

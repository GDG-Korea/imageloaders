package com.the42apps.imageloaders;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

public class ViewPropertyAnimatorUtil {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static void startAwesomeAnimation(View v) {
        v.setRotationY(180.f);
        v.animate().rotationY(0.0f).start();
    }
}

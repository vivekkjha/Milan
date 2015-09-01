package com.unite.milan.common.ui.toast;

import android.content.Context;

/**
 * Created by vaibhav.singhal on 8/27/2015.
 */
public class MilanToast {
    private static final String TAG = "KohlsToast";

    private Context mContext;
    /**
     * Instantiates a new {@value #TAG}.
     *
     * @param context {@link android.content.Context}
     */
    public MilanToast(Context context) {

        if (context == null) {

            throw new IllegalArgumentException(TAG + "Context is null");

        }

        this.mContext = context;
    }
}

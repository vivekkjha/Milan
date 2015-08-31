package com.unite.milan.common.app;

import android.app.Application;

import com.unite.milan.common.ui.toast.MilanToast;
import com.unite.milan.helper.preference.PreferenceHelper;

/**
 * Created by vaibhav.singhal on 8/27/2015.
 */
public class MilanApplication extends Application {
    private final String TAG = MilanApplication.class.getSimpleName();

    private static MilanApplication mInstance;

    private PreferenceHelper mKohlsPref;

    private boolean mIsClientConnect;

    private MilanToast mMilanToast;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public static MilanApplication getInstance() {
        return mInstance;
    }
}

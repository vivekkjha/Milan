package com.unite.milan.helper.actionbar;


import android.support.v7.app.ActionBar;
import android.app.Activity;

/**
 * Created by vaibhav.singhal on 8/31/2015.
 */
public class ActionBarHelper {
    // Action bar of the activity.
    private ActionBar mActionBar;

    // Activity on which action bar to be attached.
    private Activity mActivity;

    public ActionBarHelper(Activity activity, ActionBar actionBar) {
        mActivity = activity;
        mActionBar = actionBar;
    }
    public void initActionBarWithCustomView() {

    }

}

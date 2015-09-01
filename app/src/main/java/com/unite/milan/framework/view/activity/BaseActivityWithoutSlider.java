package com.unite.milan.framework.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.unite.milan.framework.view.controller.iface.IViewControllerListener;
import com.unite.milan.helper.actionbar.ActionBarHelper;

/**
 * Created by vaibhav.singhal on 8/27/2015.
 */
public abstract class BaseActivityWithoutSlider extends AppCompatActivity implements IViewControllerListener {

    private ActionBarHelper mActionBarHelper;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        
    }
    /**
     * It is called from onStart of the {@link Activity} to update action bar
     * views.
     */
    protected abstract void updateActionBarViews();

    protected abstract void updateViewsOnSuccess(Object object);

    protected abstract void updateViewsOnFailure(Object object);

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
    }

    @Override
    public final void notifyViewOnSuccess(final Object object) {
        if (!isFinishing()) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    updateViewsOnSuccess(object);
                }
            });
        }
    }
    @Override
    public final void notifyViewOnFailure(final Object object) {
        if (!isFinishing()) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    updateViewsOnFailure(object);
                }
            });
        }
    }
    protected void initActionBar() {
        getSupportActionBar().setBackgroundDrawable(null);
        mActionBarHelper = new ActionBarHelper(this, getSupportActionBar());
        mActionBarHelper.initActionBarWithCustomView();
    }

}

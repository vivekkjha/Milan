package com.unite.milan.framework.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.unite.milan.R;
import com.unite.milan.framework.view.controller.iface.IViewControllerListener;
import com.unite.milan.helper.actionbar.ActionBarHelper;

/**
 * Created by vaibhav.singhal on 8/27/2015.
 */
public abstract class BaseActivityWithoutSlider extends AppCompatActivity implements IViewControllerListener {

    private ActionBarHelper mActionBarHelper;
    private DrawerLayout mDrawerLayout;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        
    }
    /**
     * It is called from onStart of the {@link Activity} to update action bar
     * views.
     */
    protected abstract void updateToolBarViews();

    protected abstract void updateViewsOnSuccess(Object object);

    protected abstract void updateViewsOnFailure(Object object);

    protected abstract int getLayoutId();

    protected abstract void initializeViews(Bundle bundle);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_content_frame);
        FrameLayout contentLayout = (FrameLayout) findViewById(R.id.content_detail);
        int id = getLayoutId();
        View contentView = getLayoutInflater().inflate(id, null);
        contentLayout.addView(contentView);
        initToolBar();
        initializeViews(getIntent().getExtras());
        setupDrawer();
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
    protected void initToolBar() {

        //> add toolbar of material design as action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.mipmap.ic_launcher)); //TODO: add menu icon
            mActionBarHelper = new ActionBarHelper(this, getSupportActionBar());
            mActionBarHelper.initActionBarWithCustomView();
        }
    }

    /**
     * Method to setup drawer
     */
    private void setupDrawer()
    {
        //> set up navigational panel
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }
    }

    /**
     * Method to setupDrawer content and panel , It will be same throughout the application
     * @param navigationView NavigationalView that needs to be populated with content
     */
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        Toast.makeText(BaseActivityWithoutSlider.this, "Hello : " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    public DrawerLayout getmDrawerLayout() {
        return mDrawerLayout;
    }



}

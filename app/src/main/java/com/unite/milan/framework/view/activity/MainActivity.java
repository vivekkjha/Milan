package com.unite.milan.framework.view.activity;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.unite.milan.R;

public class MainActivity extends BaseActivityWithoutSlider {

    @Override
    protected void updateToolBarViews() {

    }

    @Override
    protected void updateViewsOnSuccess(Object object) {

    }

    @Override
    protected void updateViewsOnFailure(Object object) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initializeViews(Bundle bundle) {
        // get reference of all views here.



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home)
        {
            if(getmDrawerLayout()!=null && !getmDrawerLayout().isDrawerOpen(GravityCompat.START))
            {
                getmDrawerLayout().openDrawer(GravityCompat.START);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

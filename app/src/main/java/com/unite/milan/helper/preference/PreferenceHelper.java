package com.unite.milan.helper.preference;

import android.content.Context;
import com.google.gson.*;

/**
 * Created by vaibhav.singhal on 8/31/2015.
 */
public class PreferenceHelper {
    private final Context appContext;

    private Gson gson;

    public PreferenceHelper(Context context) {
        this.appContext = context;
    }

    private Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }
}

package org.godotengine.godot;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.godot.game.BuildConfig;

public class SQLBridge extends Godot.SingletonBase {

    private static final String TAG = "SQLBridge";
    private static Activity activity;

    public SQLBridge(Activity p_activity) {
        registerClass("SQLBridge", new String[]{
                "setValue", "setInt", "setFloat", "setBool",
                "getValue", "getInt", "getFloat", "getBool"});

        activity = p_activity;
        KeyValueStorage.set_context(activity.getApplicationContext());

        Log.d("godot", "SQLBridge:Initialized");
    }

    static public Godot.SingletonBase initialize(Activity p_activity) {
        return new SQLBridge(p_activity);
    }

    protected void onMainActivityResult(int requestCode, int resultCode, Intent data) {
    }

    protected void onMainPause() {
    }

    protected void onMainResume() {
    }

    protected void onMainDestroy() {
    }

    public void setInt(String key, int value) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Setting Int: {" + key + ":" + value + "}");
        }

        KeyValueStorage.setValue(key, Integer.toString(value));
    }

    public void setFloat(String key, float value) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Setting Float: {" + key + ":" + value + "}");
        }

        KeyValueStorage.setValue(key, Float.toString(value));
    }

    public void setBool(String key, boolean value) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Setting Bool: {" + key + ":" + value + "}");
        }

        KeyValueStorage.setValue(key, Boolean.toString(value));
    }

    public void setValue(String key, String value) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Setting String: {" + key + ":" + value + "}");
        }

        KeyValueStorage.setValue(key, value);
    }

    public int getInt(String key) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Getting Int: " + key);
        }

        return Integer.valueOf(KeyValueStorage.getValue(key));
    }

    public float getFloat(String key) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Getting Float: " + key);
        }

        return Float.valueOf(KeyValueStorage.getValue(key));
    }

    public boolean getBool(String key) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Getting Bool: " + key);
        }

        return Boolean.valueOf(KeyValueStorage.getValue(key));
    }

    public String getValue(String key) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Getting IString: " + key);
        }

        return KeyValueStorage.getValue(key);
    }
}

/*
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package de.dennisguse.opentracks.content;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.ContentObserver;
import android.net.Uri;

import de.dennisguse.opentracks.util.PreferencesUtils;

/**
 * Data source on the phone.
 *
 * @author Rodrigo Damazio
 */
class DataSource {

    private final ContentResolver contentResolver;
    private final SharedPreferences sharedPreferences;

    DataSource(Context context) {
        contentResolver = context.getContentResolver();
        sharedPreferences = PreferencesUtils.getSharedPreferences(context);
    }

    /**
     * Registers a content observer.
     *
     * @param uri      the uri
     * @param observer the observer
     */
    void registerContentObserver(Uri uri, ContentObserver observer) {
        contentResolver.registerContentObserver(uri, false, observer);
    }

    /**
     * Unregisters a content observer.
     *
     * @param observer the observer
     */
    void unregisterContentObserver(ContentObserver observer) {
        contentResolver.unregisterContentObserver(observer);
    }

    /**
     * Registers a shared preference change listener.
     *
     * @param listener the listener
     */
    void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    /**
     * Unregisters a shared preference change listener.
     *
     * @param listener the listener
     */
    void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener);
    }
}
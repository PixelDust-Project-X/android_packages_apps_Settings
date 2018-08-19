/*
 * Copyright (C) 2019 The PixelDust Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.settings.deviceinfo;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;

import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settings.core.PreferenceControllerMixin;
import com.android.settingslib.core.AbstractPreferenceController;

public class PDBuildPreferenceController extends AbstractPreferenceController implements
        PreferenceControllerMixin {

    private static final String PROPERTY_PD_BUILD = "ro.pixeldust.ota.build_date_utc";
    private static final String KEY_PD_BUILD = "pd_build";


    public PDBuildPreferenceController(Context context) {
        super(context);
    }

    @Override
    public boolean isAvailable() {
        return !TextUtils.isEmpty(SystemProperties.get(PROPERTY_PD_BUILD));
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        final Preference pref = screen.findPreference(KEY_PD_BUILD);
        if (pref != null) {
            String summary = SystemProperties.get(PROPERTY_PD_BUILD);
            pref.setSummary(summary);
        }
    }

    @Override
    public String getPreferenceKey() {
        return KEY_PD_BUILD;
    }
}


/*
 * Copyright  2017 [AllenCoder]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.allen.apputils;

import android.view.MotionEvent;
import android.view.View;

public class CheckViewInRange {
    public CheckViewInRange() {
    }

    public static boolean inRangeOfView(View view, MotionEvent ev) {
        int[] location = new int[2];
        if(view.getVisibility() != View.VISIBLE) {
            return false;
        } else {
            view.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            return ev.getRawX() >= (float)x && ev.getRawX() <= (float)(x + view.getWidth()) && ev.getRawY() >= (float)y && ev.getRawY() <= (float)(y + view.getHeight());
        }
    }
}

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

package com.allen.dbutils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Allen on 2017/3/21.
 */

public class Utils {

    /** 读文件buffer.*/
    private static final int FILE_BUFFER = 1024;
    private static String TAG="DbUtils";

    /**
     * 数据库导出到sdcard.
     * @param context
     * @param dbName 数据库名字 例如 xx.db
     */
    public static void exportDb2Sdcard(Context context,String dbName) {
        String filePath = context.getDatabasePath(dbName).getAbsolutePath();
        byte[] buffer = new byte[FILE_BUFFER];
        int length;
        OutputStream output;
        InputStream input;
        try {
            input = new FileInputStream(new File((filePath)));
            output = new FileOutputStream(context.getExternalCacheDir() + File.separator + dbName);
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            output.flush();
            output.close();
            input.close();
            Log.i(TAG, "mv success!");
        } catch (IOException e) {
            Log.e(TAG, e.toString());
        }
    }
}

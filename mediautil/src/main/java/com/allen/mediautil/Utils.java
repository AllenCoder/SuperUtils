/*
 * Copyright  2017 [AllenCoderr]
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

package com.allen.mediautil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Allen on 2017/3/21.
 */

public class Utils {
    private Utils() {

        throw new  RuntimeException("you can't instant this Utils");
    }

    /**
     * 转换图片格式
     * <p>
     * 由于原图已经被裁剪压缩成jpg格式了，因此此处直接转换为webp格式，不做大小调整
     *
     * @param file   图片文件
     * @param toFile 转换后的图片
     * @return true转换成功！
     */
    private boolean convertImgWebp(File file, File toFile) {
        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(toFile);
            bitmap.compress(Bitmap.CompressFormat.WEBP, ImageTakerHelper.IMG_QUALITY, fos);
            fos.flush();
            bitmap.recycle();
            return true;
        } catch (IOException e) {
            Log.e("convertImg","convertImg failed", e);
        } finally {
            closeSilent(fos);
        }
        return false;
    }

    private static void closeSilent(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                // null
            }
        }
    }
}

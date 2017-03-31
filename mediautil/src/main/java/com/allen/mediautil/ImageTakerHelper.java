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

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 从相机或者相册取图片辅助类
 * <p>
 * 需要 READ_EXTERNAL_STORAGE 和 WRITE_EXTERNAL_STORAGE 权限
 */
public class ImageTakerHelper {
    /**
     * 最大图片宽高
     */
    public static final int MAX_IMAGE_SIZE = 2560;
    /**
     * 缩略图最大宽高
     **/
    public static final int MAX_THUMB_IMAGE_SIZE = 120;
    /**
     * 保存的图片质量
     */
    public static final int IMG_QUALITY = 80;
    /**
     * 请求相册图片类型
     **/
    public static final String MEDIA_TYPE_IMAGE = "image/*";
    public static final String THUMB_IMG_SUFFIX = "-thumb";

    /**
     * 图片临时存储后缀
     **/
    public static final String IMG_TEMP_STORE_SUFFIX = ".jpg";
    public static final String IMG_STORE_SUFFIX = ".webp";

    public static final int REQUEST_CAMERA = 0x10;
    public static final int REQUEST_ALBUM = 0x11;

    /**
     * 图片临时保存格式
     */
    public static final Bitmap.CompressFormat IMG_TEMP_FORMAT = Bitmap.CompressFormat.JPEG;
    /**
     * 图片最终保存格式
     */
    public static final Bitmap.CompressFormat IMG_FINAL_FORMAT = Bitmap.CompressFormat.WEBP;

    /**
     * 根据图片名称获取其缩略图名称
     *
     * @param imageName 图片名称
     * @return 缩略图名称
     */
    public static String getAccountThumbNameFromImgName(String imageName) {
        if (TextUtils.isEmpty(imageName)) {
            return null;
        }
        int idx = imageName.lastIndexOf(".");
        if (idx == -1) {
            return imageName + THUMB_IMG_SUFFIX;
        }
        return imageName.substring(0, idx) + THUMB_IMG_SUFFIX + imageName.substring(idx);
    }

    /**
     * 根据原始文件名获取保存的文件名（添加后缀）
     *
     * @param name        文件名
     * @param isThumbnail true 缩略图文件名，false原图文件名
     * @return 文件名
     */
    public static String getImageSaveName(String name, Bitmap.CompressFormat format, boolean isThumbnail) {
        return name + (isThumbnail ? THUMB_IMG_SUFFIX : "") + (format == Bitmap.CompressFormat.WEBP ? ".webp"
                : (format == Bitmap.CompressFormat.PNG ? ".png" : ".jpg"));
    }

    /**
     * 打开相册获取图片 调用onActivityResult()获取图片
     */
    public static void openAlbum(Activity activity) {
        Intent intentAlbum = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intentAlbum.setType("image/*");
        activity.startActivityForResult(Intent.createChooser(intentAlbum, "选择图片"), REQUEST_ALBUM);
    }

    /**
     * 打开相册获取图片 调用onActivityResult()获取图片
     */
    public static void openAlbum(Fragment fragment) {
        Intent intentAlbum = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intentAlbum.setType(MEDIA_TYPE_IMAGE);
        fragment.startActivityForResult(Intent.createChooser(intentAlbum, "选择图片"), REQUEST_ALBUM);
    }

    /**
     * 打开相机获取图片
     * <p>
     * 调用onActivityResult()获取图片
     */
    public static void openCamera(Activity activity,String authority ) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, getOutputPictureUri(activity.getApplicationContext(),authority));
        activity.startActivityForResult(intent, REQUEST_CAMERA);
    }


    /**
     * 获取相机拍照存储的图片位置
     * 为了保证第三方相机也可以保存图片，因此设置为存储卡指定文件夹
     *
     * @param context Context
     * @return 文件位置
     */
    public static File getTmpSaveFilePath(Context context) {
        File f = new File(context.getExternalCacheDir(), "/camera/tmp.jpg");
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        return f;
    }

    /**
     * 获取相机拍照存储的图片位置Uri
     *
     * @param context
     * @param authority fileProvider 名字
     * @return
     */
    public static Uri getOutputPictureUri(Context context, String authority) {
//        String authority = context.getString(R.string.provider_authority);
        File saveFile = getTmpSaveFilePath(context);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            try {
                return FileProvider.getUriForFile(context, authority, saveFile);
            } catch (Exception e) {
                return Uri.fromFile(saveFile);
            }
        } else {
            return Uri.fromFile(saveFile);
        }
    }

    /**
     * 获取指定位置的fileuri
     *
     * @param context
     * @param file
     * @param authority fileProvider name
     * @return
     */
    public static Uri getOutputPictureUri(Context context, File file, String authority) {
//        String authority = context.getString(R.string.provider_authority);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            try {
                return FileProvider.getUriForFile(context, authority, file);
            } catch (Exception e) {
                return Uri.fromFile(file);
            }
        } else {
            return Uri.fromFile(file);
        }

    }

    /**
     * 从相册返回结果中取图片
     *
     * @param data 相册返回结果
     * @return 相册的图片位置
     */
    public static String readBitmapFromAlbumResult(Context context, Intent data) {
        Uri imageUri = data.getData();
        if (imageUri == null) {
            return null;
        } else if (imageUri.toString().startsWith("file:///")) {
            try {
                // 尝试读取图片
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(imageUri.getPath(), options);
                return imageUri.getPath();
            } catch (Exception ex) {
                Toast.makeText(context.getApplicationContext(), "无法读取该文件夹图片，请选择其他图片", Toast.LENGTH_SHORT).show();
                return null;
            }
        } else {
            String[] projection = {MediaStore.MediaColumns.DATA};
            CursorLoader cursorLoader = new CursorLoader(context, imageUri, projection, null, null, null);
            Cursor cursor = cursorLoader.loadInBackground();
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            cursor.moveToFirst();
            String selectedImagePath = cursor.getString(column_index);
            cursor.close();
            return selectedImagePath;
        }
    }


    /**
     * 从相机结果取照片
     *
     * @param data 相机返回结果
     */
    public static String readBitmapFromCameraResult(Context context, Intent data) {
        return String.valueOf(getTmpSaveFilePath(context).getPath());
    }

    /**
     * 压缩裁剪旋转图片
     * <p>
     * 保存图片到指定文件夹，并保存缩略图
     *
     * @param originalImagePath 图片路径
     * @param destDir           保存到的文件夹
     * @param saveName          保存文件名（不带后缀） 缩略图最大宽高
     * @return 压缩裁剪后的图片位置
     */
    public static String saveAccountImg(String originalImagePath, File destDir, String saveName) {
        Bitmap.CompressFormat format = IMG_TEMP_FORMAT;
        int maxSize = MAX_IMAGE_SIZE;
        int thumbnailMaxSize = MAX_THUMB_IMAGE_SIZE;

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(originalImagePath, options);
        int scale = 1;
        int size = Math.max(options.outWidth, options.outHeight);
        while (size / scale > maxSize) {
            scale *= 2;
        }
        int degree = readPictureDegree(originalImagePath);
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        Bitmap bm = BitmapFactory.decodeFile(originalImagePath, options);

        if (degree != 0) {
            Bitmap bp = rotateImageView(degree, bm);
            if (bp != bm) {
                bm.recycle();
            }
            bm = bp;
        }

        // 保存缩放后的图片
        File imageSavePos = new File(destDir, getImageSaveName(saveName, format, false));
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(imageSavePos);
            bm.compress(format, 100, fos);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeSilent(fos);
        }
        bm.recycle();

        // 保存缩略图
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(originalImagePath, options);
        scale = 1;
        size = Math.max(options.outWidth, options.outHeight);
        while (size / scale > thumbnailMaxSize) {
            scale *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = scale;
        Bitmap thumb = BitmapFactory.decodeFile(originalImagePath, options);
        try {
            fos = new FileOutputStream(new File(destDir, getImageSaveName(saveName, format, true)));
            thumb.compress(format, 100, fos);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeSilent(fos);
        }
        thumb.recycle();
        return imageSavePos.getAbsolutePath();
    }

    /**
     * 旋转图片
     *
     * @param angle  angle
     * @param bitmap bitmap
     * @return Bitmap
     */
    private static Bitmap rotateImageView(int angle, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /**
     * 读取图片属性：旋转的角度
     *
     * @param path 图片绝对路径
     * @return degree旋转的角度
     */
    private static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;// SUPPRESS CHECKSTYLE
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;// SUPPRESS CHECKSTYLE
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;// SUPPRESS CHECKSTYLE
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            Log.e("readPictureDegree", "readPictureDegree failed", e);
        }
        return degree;
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

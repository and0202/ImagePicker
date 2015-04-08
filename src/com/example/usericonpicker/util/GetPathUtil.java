package com.example.usericonpicker.util;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

public class GetPathUtil {

	/**
	 * 从相册选图片
	 */
	public static void getPictureFromLocal(Activity activity,int RequestCode) {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.addCategory(Intent.CATEGORY_OPENABLE);
		intent.setType("image/*");
		activity.startActivityForResult(intent, RequestCode);
	}

	/**
	 * 拍照
	 */

	public static void captureImage(Activity activity,int RequestCode,String filePath) {
		File imageFile = new File(filePath);
		Uri imageFileUri = Uri.fromFile(imageFile);
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageFileUri);
		activity.startActivityForResult(intent, RequestCode);
	}
}

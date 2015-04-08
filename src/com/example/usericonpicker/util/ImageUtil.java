package com.example.usericonpicker.util;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.text.format.DateFormat;

public abstract class ImageUtil {
	private String saveImageDirectory = Environment.getExternalStorageDirectory() + "";
	private String saveImageName = "zhong"+DateFormat.format("yyyy-MM-dd", new Date()) + ".jpg";
	private String saveImageAbsolutePath = saveImageDirectory + "/" + saveImageName;

	public static Activity activity;
	public static final int REQUEST_CODE_LOCAL_IMG = 101;
	public static final int REQUEST_CODE_CAPTURE_IMG = 102;
	public static final int REQUEST_CODE_IMAGE_CROP = 103;
	
	public ImageUtil(Activity activity){
		this.activity = activity;
	}
	
	public void startWork(boolean FromLocal){
		if (FromLocal) {
			GetPathUtil.getPictureFromLocal(activity, REQUEST_CODE_LOCAL_IMG);
		}else {
			GetPathUtil.captureImage(activity, REQUEST_CODE_CAPTURE_IMG, saveImageAbsolutePath);
		}
	}
	
	public void setOnActivityResult(int requestCode, int resultCode, Intent data){
		String path;
		if (requestCode == REQUEST_CODE_CAPTURE_IMG) {
			path = saveImageAbsolutePath;
		}else {
			path= HandleImageUtil.onActivityResult(activity, data);
		}
		
		uploadIconToServer(path);
	}
	
	
	public abstract void uploadIconToServer(String FilePath);
	
	public Bitmap getBitMapByWidthHeight(String filePath, int imageWidth, int imageHeight){
		return HandleImageUtil.getZoomBitmap(filePath, imageWidth, imageHeight);
	}

}

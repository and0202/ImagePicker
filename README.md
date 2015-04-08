# ImagePicker
拍照获取图片或者图库选择图片


####使用场景：
    用户通过拍照或者图库上传图片到服务器或者显示在App内部
    简单易用，而且再也不用担心OOM问题
    提高开发效率



####使用方法：
    1 初始化类ImageUtil
            imageUtil = new ImageUtil(this) {
			
      			@Override
      			public void uploadIconToServer(String FilePath) {
      				Logger.d("ImagePath:"+FilePath);
      				//通过图片路径转换成期望大小的Bitmap对象，使用ImageView展示出来
      				Bitmap bitmap = imageUtil.getBitMapByWidthHeight(FilePath, 500, 500);
      				imageView.setImageBitmap(bitmap);
      			}
      		};
    2 重写onActivityResult方法。
          @Override
        	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        		super.onActivityResult(requestCode, resultCode, data);
        		imageUtil.setOnActivityResult(requestCode, resultCode, data);
        	}

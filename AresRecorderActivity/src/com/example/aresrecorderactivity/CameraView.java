package com.example.aresrecorderactivity;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class CameraView  extends SurfaceView implements SurfaceHolder.Callback, PreviewCallback {

	Camera mCamera;
	Context mContext;
	SurfaceHolder mHolder;
	String TAG = "CameraView";
	boolean isPreviewOn = false;
	Parameters cameraParameters;
	Activity mCurrentActivity;
	
	//Ԥ��֡��
	int frameRate = 30;
	
	public CameraView(Camera camera,Context context,Activity activity)
	{
		super(context);
		mCamera = camera;
		mContext = context;
		mCurrentActivity = activity;
		mHolder = getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		mCamera.setPreviewCallback(this);
	}
	
	/**
	 * ÿһ֡����ص�
	 */
	@Override
	public void onPreviewFrame(byte[] arg0, Camera arg1) {
		// TODO Auto-generated method stub
	//	Log.d(TAG, "onPreViewFrame");
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int arg1, int w, int h) {
		// TODO Auto-generated method stub
		Log.d(TAG, "sufaceChanged width " + w + "; height " + h +";");
		if (isPreviewOn)
			mCamera.stopPreview();
		handleSurfaceChanged();
		startPreview();  
		mCamera.autoFocus(null);

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) 
	{
		Log.d(TAG, "sufaceCreate");
		// TODO Auto-generated method stub
		try {
			//stopPreview();
			mCamera.setPreviewDisplay(holder);
			cameraParameters = mCamera.getParameters();
		} catch (IOException exception) {
			mCamera.release();
			mCamera = null;
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Log.d(TAG, "surfaceDestroyed");
		try {
			mHolder.addCallback(null);
			mCamera.setPreviewCallback(null);
			
		} catch (RuntimeException e) {
		}
	}
	/**
	 * ��������ͷ��Ԥ��
	 */
	public void startPreview() {
		if (!isPreviewOn && mCamera != null) {
			isPreviewOn = true;
			mCamera.startPreview();
		}
	}
	/**
	 * �ر�����ͷ��Ԥ��
	 */
	public void stopPreview() {
		if (isPreviewOn && mCamera != null) {
			isPreviewOn = false;
			mCamera.stopPreview();

		}
	}
	
	private void handleSurfaceChanged()
	{
		if(mCamera == null){
			//showToast(this, "�޷����ӵ����");
		//	finish();
			Toast.makeText(mContext, "�޷����ӵ����", Toast.LENGTH_SHORT).show();
			return;
		}
		//��ȡ����ͷ������֧�ֵķֱ���
		List<Camera.Size> resolutionList = getResolutionList(mCamera);
		if(resolutionList != null && resolutionList.size() > 0)
		{
			Collections.sort(resolutionList, new Comparator<Camera.Size>() 
					{
						@Override
						public int compare(Size arg0, Size arg1) {
							// TODO Auto-generated method stub
							if(arg0.height != arg1.height)
								return arg0.height - arg1.height;
							else
								return arg0.width - arg1.width;
						}	
			} );
			Camera.Size previewSize =  null;	
			if(MainActivity.defaultScreenResolution == -1){
				boolean hasSize = false;
				//�������ͷ֧��640*480����ôǿ����Ϊ640*480
				for(int i = 0;i<resolutionList.size();i++){
					Size size = resolutionList.get(i);
					if(size != null && size.width==640 && size.height==480){
						previewSize = size;
						hasSize = true;
						break;
					}
				}
				//�����֧����Ϊ�м���Ǹ�
				if(!hasSize){
					int mediumResolution = resolutionList.size()/2;
					if(mediumResolution >= resolutionList.size())
						mediumResolution = resolutionList.size() - 1;
					previewSize = resolutionList.get(mediumResolution);
				}
			}else{
				if(MainActivity.defaultScreenResolution >= resolutionList.size())
					MainActivity.defaultScreenResolution = resolutionList.size() - 1;
				previewSize = resolutionList.get(MainActivity.defaultScreenResolution);
			}
			//��ȡ�����������ͷ�ֱ���
			if(previewSize != null ){
			//	previewWidth = previewSize.width;
			//	previewHeight = previewSize.height;
				cameraParameters.setPreviewSize(previewSize.width, previewSize.height);
		

			}
		}
		
		//����Ԥ��֡��
		cameraParameters.setPreviewFrameRate(frameRate);
		//ϵͳ�汾Ϊ8һ�µĲ�֧�����ֶԽ�
		if(Build.VERSION.SDK_INT >  Build.VERSION_CODES.FROYO)
		{
			mCamera.setDisplayOrientation(determineDisplayOrientation(mCurrentActivity, MainActivity.defaultCameraId));
			List<String> focusModes = cameraParameters.getSupportedFocusModes();
			if(focusModes != null){
				Log.i("video", Build.MODEL);
				 if (((Build.MODEL.startsWith("GT-I950"))
						 || (Build.MODEL.endsWith("SCH-I959"))
						 || (Build.MODEL.endsWith("MEIZU MX3")))&&focusModes.contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)){
						
					 cameraParameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
				 }else if(focusModes.contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO)){
					cameraParameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
				}else
					cameraParameters.setFocusMode(Camera.Parameters.FOCUS_MODE_FIXED);
			}
		}
		else
			mCamera.setDisplayOrientation(90);
		mCamera.setParameters(cameraParameters);
	}

	public static List<Camera.Size> getResolutionList(Camera camera)
	{ 
		Parameters parameters = camera.getParameters();
		List<Camera.Size> previewSizes = parameters.getSupportedPreviewSizes();


		return previewSizes;
	}
	
	//����activity��״̬������or�������ж�camera�ĽǶ�
	public static int determineDisplayOrientation(Activity activity, int defaultCameraId) {
		int displayOrientation = 0;
		if(Build.VERSION.SDK_INT >  Build.VERSION_CODES.FROYO)
		{
			CameraInfo cameraInfo = new CameraInfo();
			Camera.getCameraInfo(MainActivity.defaultCameraId, cameraInfo);

			int degrees  = getRotationAngle(activity);


			if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
				displayOrientation = (cameraInfo.orientation + degrees) % 360;
				displayOrientation = (360 - displayOrientation) % 360;
			} else {
				displayOrientation = (cameraInfo.orientation - degrees + 360) % 360;
			}
		}
		return displayOrientation;
	}
	public static int getRotationAngle(Activity activity)
	{
		int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
		int degrees  = 0;

		switch (rotation) {
		case Surface.ROTATION_0:
			degrees = 0;
			break;

		case Surface.ROTATION_90:
			degrees = 90;
			break;

		case Surface.ROTATION_180:
			degrees = 180;
			break;

		case Surface.ROTATION_270:
			degrees = 270;
			break;
		}
		return degrees;
	}
	
	
}

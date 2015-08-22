package com.example.aresrecorderactivity;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private Camera mCamera;
	private CameraView mCameraView;
	private SurfaceHolder mSurfaceHolder;
	private FrameLayout mContentView;
	private LayoutInflater mInflater;
	private Button mBtnRecord;
	
	//分别为 默认摄像头（后置）、默认调用摄像头的分辨率、被选择的摄像头（前置或者后置）
	public static int defaultCameraId = -1, defaultScreenResolution = -1 , cameraSelection = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initView();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void initData()
    {
    	setCamera();
    }
    
    private void initView()
    {
    	mInflater = getLayoutInflater();
    	mContentView = (FrameLayout) mInflater.inflate(R.layout.activity_main, null);
    	mCameraView = (CameraView) mContentView.findViewById(R.id.camera_view);
    	mCameraView.initData(mCamera, this, this);
    	mBtnRecord = (Button) mContentView.findViewById(R.id.btn_record);
    	mBtnRecord.setOnTouchListener(mTounchListener);
        setContentView(mContentView);
    }
    
    private OnTouchListener mTounchListener = new OnTouchListener() {
		
		@Override
		public boolean onTouch(View arg0, MotionEvent arg1) {
			// TODO Auto-generated method stub
			if(arg1.getAction() == MotionEvent.ACTION_DOWN)
			{
				mCameraView.recording = true;
			}
			else if(arg1.getAction() == MotionEvent.ACTION_UP)
			{
				mCameraView.recording = false;
			}
			return false;
		}
	};
	
	private boolean setCamera()
	{
		try
		{
			
			if(Build.VERSION.SDK_INT > Build.VERSION_CODES.FROYO)
			{
				int numberOfCameras = Camera.getNumberOfCameras();
				
				CameraInfo cameraInfo = new CameraInfo();
				for (int i = 0; i < numberOfCameras; i++) {
					Camera.getCameraInfo(i, cameraInfo);
					if (cameraInfo.facing == cameraSelection) 
					{
						defaultCameraId = i;
					}
				}
			}
		//	stopPreview();
			if(mCamera != null)
				mCamera.release();
			
			if(defaultCameraId >= 1)
				mCamera = Camera.open(defaultCameraId);
			else
				mCamera = Camera.open();

		}
		catch(Exception e)
		{	
			return false;
		}
		return true;
	}
}

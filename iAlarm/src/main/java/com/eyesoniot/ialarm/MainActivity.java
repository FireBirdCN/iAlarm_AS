package com.eyesoniot.ialarm;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	ImageButton leavHomeBtn,inHomeBtn,sosBtn,cancelBtn,customeBtn,settingBtn;
	NotificationManager nManager;
	int Notification_ID_BASE = 110;
	//private PendingIntent pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leavHomeBtn=(ImageButton)findViewById(R.id.imageButton_Leave);
        inHomeBtn=(ImageButton)findViewById(R.id.imageButton_Athome);
        cancelBtn=(ImageButton)findViewById(R.id.imageButton_Cancel);
        sosBtn=(ImageButton)findViewById(R.id.imageButton_SOS);
        settingBtn=(ImageButton)findViewById(R.id.imageButton_Setting);
        customeBtn=(ImageButton)findViewById(R.id.imageButton_Custome);
        //leavHomeBtn.setOnClickListener(listener);
        inHomeBtn.setOnTouchListener(touchlistener);
        cancelBtn.setOnTouchListener(touchlistener);
        sosBtn.setOnTouchListener(touchlistener);
        settingBtn.setOnTouchListener(touchlistener);
        leavHomeBtn.setOnTouchListener(touchlistener);
        customeBtn.setOnTouchListener(touchlistener);
        nManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        //Intent intent = new Intent(this,MainActivity.class);
        //pd = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

    }
    private OnTouchListener touchlistener=new OnTouchListener() {

		@SuppressWarnings("deprecation")
		@Override
		public boolean onTouch(View arg0, MotionEvent arg1) {
			if (arg1.getAction() == MotionEvent.ACTION_DOWN) return true;

	        // don't handle event unless its ACTION_UP so "doSomething()" only runs once.
	        if (arg1.getAction() != MotionEvent.ACTION_UP) return false;
	        //leavHomeBtn.setPressed(true);
			switch (arg0.getId()) {
			case R.id.imageButton_Leave:
				Toast.makeText(MainActivity.this,"LeaveHome Mode", Toast.LENGTH_SHORT).show();
		        	Notification n;
				Notification.Builder builder=new Notification.Builder(MainActivity.this);
				builder.setContentInfo("离家布防");
				builder.setContentText("已开启离家设防");
				builder.setContentTitle("离家布防");
				builder.setSmallIcon(R.drawable.leavehome_icon);
				builder.setTicker("离家布防");
				builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
				n=builder.build();
				nManager.notify(Notification_ID_BASE, n);

				inHomeBtn.setPressed(false);
				customeBtn.setPressed(false);
				sosBtn.setPressed(false);
				cancelBtn.setPressed(false);
				settingBtn.setPressed(false);
				leavHomeBtn.setPressed(true);

				break;

			case R.id.imageButton_Athome:
				Toast.makeText(MainActivity.this,"AtHome Mode", Toast.LENGTH_SHORT).show();

				Notification n_at;
				Notification.Builder builder_at=new Notification.Builder(MainActivity.this);
				builder_at.setContentInfo("居家布防");
				builder_at.setContentText("已开启居家设防");
				builder_at.setContentTitle("居家布防");
				builder_at.setSmallIcon(R.drawable.inhome_icon);
				builder_at.setTicker("居家布防");
				builder_at.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
				n_at=builder_at.build();
				nManager.notify(Notification_ID_BASE+3, n_at);

				leavHomeBtn.setPressed(false);
				inHomeBtn.setPressed(true);
				customeBtn.setPressed(false);
				sosBtn.setPressed(false);
				cancelBtn.setPressed(false);
				settingBtn.setPressed(false);
				break;

			case R.id.imageButton_Cancel:
				Toast.makeText(MainActivity.this,"CancelAlarm ", Toast.LENGTH_SHORT).show();
				leavHomeBtn.setPressed(false);
				inHomeBtn.setPressed(false);
				customeBtn.setPressed(false);
				sosBtn.setPressed(false);
				cancelBtn.setPressed(true);
				settingBtn.setPressed(false);
				break;
			case R.id.imageButton_Custome:
				Toast.makeText(MainActivity.this,"Custome Mode", Toast.LENGTH_SHORT).show();
				leavHomeBtn.setPressed(false);
				inHomeBtn.setPressed(false);
				customeBtn.setPressed(true);
				sosBtn.setPressed(false);
				cancelBtn.setPressed(false);
				settingBtn.setPressed(false);
				final Snackbar snackbar = Snackbar.make(arg0,"你点击按钮", Snackbar.LENGTH_SHORT);//新提示方式
				snackbar.show();

				break;
			case R.id.imageButton_Setting:
				Toast.makeText(MainActivity.this,"Setting ", Toast.LENGTH_SHORT).show();
				leavHomeBtn.setPressed(false);
				inHomeBtn.setPressed(false);
				customeBtn.setPressed(false);
				sosBtn.setPressed(false);
				cancelBtn.setPressed(false);
				settingBtn.setPressed(true);
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, SettingActivity.class);
				startActivity(intent);
				break;
			case R.id.imageButton_SOS:
				Toast.makeText(MainActivity.this,"SOS Alarm", Toast.LENGTH_SHORT).show();

				Notification n_sos;
		    	Notification.Builder builder_sos=new Notification.Builder(MainActivity.this);
				builder_sos.setContentInfo("报警");
				builder_sos.setContentText("已开启报警");
				builder_sos.setContentTitle("报警");
				builder_sos.setSmallIcon(R.drawable.sos_icon);
				builder_sos.setTicker("警报");
				builder_sos.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
				n_sos=builder_sos.build();
		    	nManager.notify(Notification_ID_BASE+1, n_sos);

				leavHomeBtn.setPressed(false);
				inHomeBtn.setPressed(false);
				customeBtn.setPressed(false);
				sosBtn.setPressed(true);
				cancelBtn.setPressed(false);
				settingBtn.setPressed(false);
				break;

			}

			return true;
		}
	};

    
//    private OnClickListener listener=new OnClickListener() {
//
//		@Override
//		public void onClick(View arg0) {
//			switch (arg0.getId()) {
//			case R.id.imageButton_Leave:
//				Toast.makeText(MainActivity.this,"LeaveHome Mode", Toast.LENGTH_SHORT).show();
//				inHomeBtn.setPressed(false);
//				customeBtn.setPressed(false);
//				sosBtn.setPressed(false);
//				cancelBtn.setPressed(false);
//				settingBtn.setPressed(false);
//				leavHomeBtn.setFocusable(true);
//				leavHomeBtn.setPressed(true);
//				break;
//
//			case R.id.imageButton_Athome:
//				Toast.makeText(MainActivity.this,"AtHome Mode", Toast.LENGTH_SHORT).show();
//				leavHomeBtn.setPressed(false);
//				inHomeBtn.setPressed(true);
//				customeBtn.setPressed(false);
//				sosBtn.setPressed(false);
//				cancelBtn.setPressed(false);
//				settingBtn.setPressed(false);
//				break;
//			case R.id.imageButton_Cancel:
//				Toast.makeText(MainActivity.this,"CancelAlarm Mode", Toast.LENGTH_SHORT).show();
//				leavHomeBtn.setPressed(false);
//				inHomeBtn.setPressed(false);
//				customeBtn.setPressed(false);
//				sosBtn.setPressed(false);
//				cancelBtn.setPressed(true);
//				settingBtn.setPressed(false);
//				break;
//			case R.id.imageButton_Custome:
//				Toast.makeText(MainActivity.this,"Custome Mode", Toast.LENGTH_SHORT).show();
//				leavHomeBtn.setPressed(false);
//				inHomeBtn.setPressed(false);
//				customeBtn.setPressed(true);
//				sosBtn.setPressed(false);
//				cancelBtn.setPressed(false);
//				settingBtn.setPressed(false);
//				break;
//			case R.id.imageButton_Setting:
//				Toast.makeText(MainActivity.this,"Setting Mode", Toast.LENGTH_SHORT).show();
//				leavHomeBtn.setPressed(false);
//				inHomeBtn.setPressed(false);
//				customeBtn.setPressed(false);
//				sosBtn.setPressed(false);
//				cancelBtn.setPressed(false);
//				settingBtn.setPressed(true);
//				break;
//			case R.id.imageButton_SOS:
//				Toast.makeText(MainActivity.this,"SOS Mode", Toast.LENGTH_SHORT).show();
//				leavHomeBtn.setPressed(false);
//				inHomeBtn.setPressed(false);
//				customeBtn.setPressed(false);
//				sosBtn.setPressed(true);
//				cancelBtn.setPressed(false);
//				settingBtn.setPressed(false);
//				break;
//
//			}
//
//
//
//		}
//	};
//
//
//
//
//






}

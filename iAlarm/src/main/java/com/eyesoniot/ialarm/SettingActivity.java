package com.eyesoniot.ialarm;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.eyesoniot.ialarm.Fragment_dialog_addacc.LoginInputListener;

public class SettingActivity extends Activity implements LoginInputListener   {//??????

	private final static int ADDDEVICESDIALOG=1;
	private final static int ALARMCONFIGDIALOG=2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		
		 if (savedInstanceState == null) {
	            getFragmentManager().beginTransaction()
	                    .add(R.id.container, new SysConfigFragment())
	                    .commit();
	        }
		 if (savedInstanceState == null) {
	            getFragmentManager().beginTransaction()
	                    .add(R.id.container2, new AccListFragment())
	                    .commit();
	        }
		
		
	}
	   public static class SysConfigFragment extends Fragment {  //??????? ???
		   

	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
	            View rootView = inflater.inflate(R.layout.fragment_setting, container, false);
	            
	            return rootView;
	        }
	        
	        @Override
			public void onActivityCreated(Bundle savedInstanceState) {
				super.onActivityCreated(savedInstanceState);
				LinearLayout AccessoriesCfg=(LinearLayout)getActivity().findViewById(R.id.AccessoriesCfg);
				AccessoriesCfg.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						//AccFragment dialogFragment =new AccFragment();
				        //dialogFragment.show(getFragmentManager(), "dialog"); 
						getFragmentManager().beginTransaction().replace(R.id.container2,new AccListFragment())
						.commit();
					}
				});
				LinearLayout dateCfgButton =(LinearLayout)getActivity().findViewById(R.id.DateCfg);
				dateCfgButton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						getFragmentManager().beginTransaction().replace(R.id.container2,new DateCfgFragment())
						.commit();
					}
				});
			
				
				
				
			}
	    }
	   public static class AccListFragment extends Fragment {   //????б?
		   

	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
	            View rootView = inflater.inflate(R.layout.fragment_acclist, container, false);
	            
	            return rootView;
	        }
	        
	        @Override
			public void onActivityCreated(Bundle savedInstanceState) {
				super.onActivityCreated(savedInstanceState);
				LinearLayout AccessoriesCfg=(LinearLayout)getActivity().findViewById(R.id.AddAccButton);
				//ImageView AccessoriesCfg=(ImageView)getActivity().findViewById(R.id.AddAccButton);
				AccessoriesCfg.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Fragment_dialog_addacc dialogFragment =new Fragment_dialog_addacc();      //????????Fragment?????
				        dialogFragment.show(getFragmentManager(), "dialog"); 
						//LoginInputListener listener = (LoginInputListener) getActivity();  
		                //listener.onLoginInputComplete("AddDevice","Button Clicked");  
					}
				});
			
				
				
				
			}
	    }
	   public static class DateCfgFragment extends Fragment {  //???????

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			 View rootView = inflater.inflate(R.layout.fragment_datecfg, container, false);
			 return rootView;
		}
		   
		
	}
	   
//	public void doPositiveClick() {
//		// ---perform steps when user clicks on OK---
//		Log.d("DialogFragmentExample", "User clicks on OK");
//	}
//
//	public void doNegativeClick() {
//		// ---perform steps when user clicks on Cancel---
//		Log.d("DialogFragmentExample", "User clicks on Cancel");
//	}

	@Override
	public void onLoginInputComplete(String username, String password) {
		Toast.makeText(this, username + password,  
                Toast.LENGTH_SHORT).show();  
		
	}
				  
}

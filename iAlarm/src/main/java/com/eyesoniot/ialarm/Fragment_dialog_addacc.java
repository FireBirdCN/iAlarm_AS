package com.eyesoniot.ialarm;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Fragment_dialog_addacc extends DialogFragment  {
	 private EditText mAccname;
	 private Button mButton;  
	static Fragment_dialog_addacc newInstance(String title) { 
		Fragment_dialog_addacc fragment = new Fragment_dialog_addacc(); 
        Bundle args = new Bundle(); 
        args.putString("title", title); 
        fragment.setArguments(args); 
        return fragment; 
    }
		  
	
	
	    public interface LoginInputListener  
	    {  
	        void onLoginInputComplete(String username, String password);  
	    }  
	    
	    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	//	 getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
		View view = inflater.inflate(R.layout.fragment_dialog_addacc, container);  
		mAccname = (EditText) view.findViewById(R.id.Acc_name);
        mButton = (Button) view.findViewById(R.id.id_sure_edit_name);  
		mButton.setOnClickListener(new OnClickListener() {
	//拿到username和password的引用，在点击登录的时候，把activity强转为我们自定义的接口：LoginInputListener，然后将用户输入的数据返回。
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LoginInputListener listener = (LoginInputListener) getActivity();  
                listener.onLoginInputComplete(mAccname
                        .getText().toString(), mButton  
                        .getText().toString());  
                dismiss();
			}
		});
		
        return view;  
		//return super.onCreateView(inflater, container, savedInstanceState);
	} 
   
//    @Override 
//    public Dialog onCreateDialog(Bundle savedInstanceState) { 
//        String title = getArguments().getString("title"); 
//        return new AlertDialog.Builder(getActivity()) 
//        .setIcon(R.drawable.ic_launcher) 
//        .setTitle(title) 
//        .setPositiveButton("OK", 
//                new DialogInterface.OnClickListener() { 
//            public void onClick(DialogInterface dialog, 
//                    int whichButton) { 
//                ((SettingActivity) getActivity()).doPositiveClick(); 
//            } 
//        }) 
//        .setNegativeButton("Cancel", 
//                new DialogInterface.OnClickListener() { 
//            public void onClick(DialogInterface dialog, 
//                    int whichButton) { 
//                ((SettingActivity) getActivity()).doNegativeClick(); 
//            } 
//        }).create(); 
//    }        
}

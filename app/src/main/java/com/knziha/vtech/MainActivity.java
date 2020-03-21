package com.knziha.vtech;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		CMN.Log("我未被劫持123?");
		CMN.Log("我未被劫持123456?", toastMessage());
		Toast.makeText(MainActivity.this, toastMessage(), Toast.LENGTH_SHORT).show();
		
	}
	
	public String toastMessage() {
		CMN.Log("……未劫持");
		return "我未被劫持";
	}
}

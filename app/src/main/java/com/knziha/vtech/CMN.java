package com.knziha.vtech;

import android.view.View;
import android.view.ViewGroup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;


//common
public class CMN {
	public static void Log(Object... o) {
		String msg="";
		if(o!=null)
		for(int i=0;i<o.length;i++) {
			if(Exception.class.isInstance(o[i])) {
				ByteArrayOutputStream s = new ByteArrayOutputStream();
				PrintStream p = new PrintStream(s);
				((Exception)o[i]).printStackTrace(p);
				msg+=s.toString();
			}
			msg+=o[i]+" ";
		}
		android.util.Log.d("fatal poison",msg);
	}
	public static void recurseLog(View v,String... depths) {
		String depth = depths!=null && depths.length>0?depths[0]:"- ";
		String depth_plus_1=depth+"- ";
		if(!ViewGroup.class.isInstance(v)) return;
		ViewGroup vg = (ViewGroup) v;
		for(int i=0;i<vg.getChildCount();i++) {
			View CI = vg.getChildAt(i);
			Log(depth+CI+" == "+Integer.toHexString(CI.getId())+"/"+CI.getBackground());
			if(ViewGroup.class.isInstance(CI))
				recurseLog(CI,depth_plus_1);
		}
	}
	public static void recurseLogCascade(View now) {
		if(now==null) return;
		while(now.getParent()!=null) {
	    	if(!View.class.isInstance(now.getParent())) {
	    		Log("-!-reached none view object or null : "+now.getParent());
	    		break;
	    	}
	    	now=(View) now.getParent();
	    }
		Log("Cascade Start Is : "+now+" == "+Integer.toHexString(now.getId())+"/"+now.getBackground());
		recurseLog(now);
		//now.setBackgroundResource(R.drawable.popup_shadow);
	}
	//[!1] End debug flags and methods*/
	
	
}
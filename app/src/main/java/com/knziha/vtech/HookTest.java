package com.knziha.vtech;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookTest implements IXposedHookLoadPackage{
	
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
		if (loadPackageParam.packageName.equals("com.knziha.vtech")) {
			XposedBridge.log(" has Hooked!");
			Class clazz = loadPackageParam.
					classLoader.loadClass("com.knziha.vtech.MainActivity");
			XposedHelpers.findAndHookMethod(clazz, "toastMessage", new XC_MethodHook() {
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					super.beforeHookedMethod(param);
					//XposedBridge.log(" has Hooked!");
					param.setResult("你已被劫持哈哈哈");
				}
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
				
				}
			});
		}
	}
}
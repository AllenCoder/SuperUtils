/**
 * Create by Allen
 * 
 */

package com.allen.apputils;

public class LogInfo {
	private static final int LENGTH = 5;

	private static final boolean DEBUG = true;

	enum InfoKind{
		FILE_NAME,
		METHOD_NAME,
		CLASS_NAME,
		LINE_NUM
	}
	 
	public static String getFileName() {
		return getInfo(InfoKind.FILE_NAME);
	}
	 
	public static String getMethodName() {
		return getInfo(InfoKind.METHOD_NAME);
	}
	 
	public static String getClassName() {
		return getInfo(InfoKind.CLASS_NAME);
	}
	
	public static  String getLineNumber() {
		 return getInfo(InfoKind.LINE_NUM);
	}

	private static String getInfo(InfoKind kind) {
		String ret = "";
		
		if(!DEBUG) {
			return ret;
		}
		
		StackTraceElement[] stackTraceElements = Thread.currentThread()
				.getStackTrace();
		if (stackTraceElements != null && stackTraceElements.length >= LENGTH) {
			StackTraceElement stackTraceElement = stackTraceElements[LENGTH - 1];
			switch (kind) {
			case FILE_NAME:
				ret = stackTraceElement.getFileName();
				break;
			case METHOD_NAME:
				ret = stackTraceElement.getMethodName();
				break;
			case CLASS_NAME:
				ret = stackTraceElement.getClassName();
				break;
			case LINE_NUM:
				ret = Integer.toString(stackTraceElement.getLineNumber());
				break;

			default:
				break;
			}
		}
		return ret;
	}
	
	static StackTraceElement getInfoInternal(int length) {
		StackTraceElement ret = null;
		
		if(!DEBUG) {
			return ret;
		}
		
		StackTraceElement[] stackTraceElements = Thread.currentThread()
				.getStackTrace();
		if (stackTraceElements != null && stackTraceElements.length >= length) {
			ret = stackTraceElements[length - 1];
			
		}
		return ret;
	}

}

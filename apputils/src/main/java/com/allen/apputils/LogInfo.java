/*
 * Copyright  2017 [AllenCoderr]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

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

package com.allen.apputils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils {
	
	static MessageDigest getDigest(String algorithm){
		try{
			return MessageDigest.getInstance(algorithm); 
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private static MessageDigest getMd5Digest(){
		return getDigest("MD5");
	}

	public static byte[] md5(byte[] data){
		return getMd5Digest().digest(data);
	}


	public static String md5Hex(byte[] data){
		return Hex.encodeHexString(md5(data));
	}
	  
}

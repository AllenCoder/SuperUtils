package com.allen.apputils;
 
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 数据转换工具类
 * @author AllenCoder
 * */
public class DataUtil {

    /**
     * The high digits lookup table.
     */
    private static final byte[] highDigits;

    /**
     * The low digits lookup table.
     */
    private static final byte[] lowDigits;

    /**
     * Initialize lookup tables.
     */
    static {
        final byte[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

        int i;
        byte[] high = new byte[256];
        byte[] low = new byte[256];

        for (i = 0; i < 256; i++) {
            high[i] = digits[i >>> 4];
            low[i] = digits[i & 0x0F];
        }

        highDigits = high;
        lowDigits = low;
    }
    public static String getHexdump(int data, int lengthLimit) {
        if (lengthLimit == 0) {
            throw new IllegalArgumentException("lengthLimit: " + lengthLimit + " (expected: 1+)");
        }

        int size;
        size = lengthLimit;

        if (size == 0) {
            return "empty";
        }

        StringBuilder out = new StringBuilder(size * 3 + 3);


        // fill the first
        int byteValue = data& 0xFF;
        out.append((char) highDigits[byteValue]);
        out.append((char) lowDigits[byteValue]);
        size--;

        // and the others, too
        for (; size > 0; size--) {
            out.append(' ');
            byteValue = data & 0xFF;
            out.append((char) highDigits[byteValue]);
            out.append((char) lowDigits[byteValue]);
        }



        return out.toString();
    }
 
    /**
     * 十六进制 2 字符串
     * @param b
     * @return
     */
    public static String toHex(byte b) {
        return ("" + "0123456789ABCDEF".charAt(0xf & b >>  4) + "0123456789ABCDEF".charAt(b & 0xf)); 
    }
    /**
     * 字符串   to 字节数组
     * */
    public static byte[] getHexBytes(String message) {
        int len = message.length() /  2;
        char[] chars = message.toCharArray();
        String[] hexStr = new String[len];
        byte[] bytes = new byte[len];
        for (int i =  0, j =  0; j < len; i +=  2, j++) {
            hexStr[j] = "" + chars[i] + chars[i +  1];
            bytes[j] = (byte) Integer.parseInt(hexStr[j], 16);
        }
        return bytes;
    }
    public static byte[] hexStringToBytes(String hexString) {
         if (hexString == null || hexString.equals("")) {   
                return null;   
         }   
         hexString = hexString.toUpperCase();   
         int length = hexString.length() /  2;   
         char[] hexChars = hexString.toCharArray();   
         byte[] d = new byte[length];   
         for (int i =  0; i < length; i++) {   
           int pos = i *  2;   
           d[i] = (byte) (charToByte(hexChars[pos]) <<  4 | charToByte(hexChars[pos +  1]));   
         }   
         return d;   
      }  
 
     private static byte charToByte(char c) {   
        return (byte) "0123456789ABCDEF".indexOf(c);   
     }  
 
     
 
    /**
     * 从输入流以字节形式读取数据
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len =  0;
        while( (len = inStream.read(buffer)) !=- 1 ){
            outSteam.write(buffer,  0, len);
        }
        outSteam.close();
        inStream.close();
        return outSteam.toByteArray();
    }
}

package com.su.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

//MD5加密
public class MD5Util {
    private  static  final String hexDigits[]={
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f"
    };

private  static String byteArrayToHexString(byte b[]){
    StringBuffer resul= new StringBuffer();
    for (int i=0;i<b.length;i++){
       resul.append(byteToHexString(b[i]));
    }
    return resul.toString();
}

private static String byteToHexString(byte b){
     int n=b;
     if (n<0){
         n+=256;
     }
     int d1=n/16;
     int d2=n%16;
     return  hexDigits[d1]+hexDigits[d2];
}

//返回大写的md5
    /*
    * cur:传入的字符串
    * encode:utf-8，为byte设置编码
    * MessageDigest:java自带的加密
    * digest(byte[] a):使用指定的字节数组对摘要进行最后更新，然后完成摘要计算。
    * */
    private  static String MD5Encode(String cur,String encode){
    String result=null;
    try {
        result=new String(cur);
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        if (encode == null || "".equals(encode)) {

           result=byteArrayToHexString(md5.digest(result.getBytes()));
        }else{
            result=byteArrayToHexString(md5.digest(result.getBytes(encode)));
        }

    }catch (Exception e){
       e.getMessage();
    }
    return  result.toUpperCase();
    }



    //加密入口
    public static String MD5EncodeUtf8(String cur){

        return  MD5Encode(cur,"utf-8");
    }

}

package com.company;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Шифрование
 * Created by Андрей on 26.04.2017.
 */

public class MD5 {

    public String getHash(String str) {
        MessageDigest md5 ;
        StringBuffer  hexString = new StringBuffer();
        try {
            //код шифрования
            md5 = MessageDigest.getInstance("ARC");
            md5.reset();
            //шифруем байты строки str
            md5.update(str.getBytes());
            byte messageDigest[] = md5.digest();
            for (int i = 0; i < messageDigest.length; i++) {
                //представляем каждый байт ввиде 16ричного числа (строки) и добавляем к hexString
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
        }
        catch (NoSuchAlgorithmException e) {
            return e.toString();
        }
        return hexString.toString();
    }
}

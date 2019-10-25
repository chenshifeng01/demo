package com.csf.common.encryptor;

import org.apache.commons.lang3.StringUtils;
import org.jasypt.util.text.BasicTextEncryptor;
import org.joda.time.MutableDateTime;

/**
 * 安全认证工具
 * 用于加密和加密，进行认证，可以用来生成token
 */
public class SecurityUtils {

    private static final String PASSWORD = "common-demo";

    /**
     * 获取当前时间，分钟和秒都是零 ，2019-01-13T13:00:00
     *
     * @return
     */
    public static String now() {
        MutableDateTime dateTime = MutableDateTime.now();
        dateTime.setMinuteOfHour(0);
        dateTime.setSecondOfMinute(0);
        return dateTime.toString("yyyy-MM-dd'T'HH:mm:ss");
    }

    /**
     * 加密：以时间进行加密
     *
     * @return
     */
    public static String encrypt() {
        String now = now();
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword(PASSWORD);
        return encryptor.encrypt(now);
    }


    /**
     * 解密：返回加密之前的文本
     *
     * @param encryptedMessage 密文
     * @return 解密之后的文本
     */
    public static String decrypt(String encryptedMessage) {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword(PASSWORD);
        return encryptor.decrypt(encryptedMessage);
    }


    /**
     * 认证
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        String now = now();
        String decrypt = decrypt(token);
//        now.compareTo(decrypt) == 0;  //如果是等于零的情况下，就相当于两个时间都是相等的，此认证的token生效一个小时
        if (StringUtils.equals(now, decrypt)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println("当前时间：" + now());
        String encrypt = encrypt();
        System.out.println("加密之后的密文：" + encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println("解密之后的文本：" + decrypt);
        boolean verify = verify(encrypt);
        System.out.println("进行验证token是否合法：" + verify);

    }

}

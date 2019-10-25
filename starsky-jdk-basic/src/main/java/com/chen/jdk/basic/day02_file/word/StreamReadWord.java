package com.chen.jdk.basic.day02_file.word;

import java.io.FileInputStream;
import java.util.Arrays;

public class StreamReadWord {

    public static void main(String[] args) throws Exception {

        FileInputStream  inputStream = new FileInputStream("/Users/chenshifeng/Documents/project/idea/java/starsky-jdk-basic/src/main/resources/2.doc");


        //2、开始读取信息
        //先定义一个字节数组存放数据
        byte[] b = new byte[inputStream.available()];//把所有的数据读取到这个字节当中

        int off = 0;
        int le = 2;
        while(inputStream.read(b, off, 2)!=-1){
            off+=1;
        }
        inputStream.read(b,off,2);

        System.out.println(Arrays.toString(b));//读取的是字节数组
        //把字节数组转成字符串
        System.out.println(new String(b));


    }

}

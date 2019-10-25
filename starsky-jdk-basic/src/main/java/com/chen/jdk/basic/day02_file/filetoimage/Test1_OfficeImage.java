package com.chen.jdk.basic.day02_file.filetoimage;



import java.io.File;

/**
 * 测试office 转化成 pdf
 * 使用  icepdf 进行转化
 * @author yangnuo
 * 创建时间：2017年3月16日
 */
public class Test1_OfficeImage {

    public static void main(String[] args) {
        //word 转 pdf
        OfficeToPDF wordToPDF = new OfficeToPDF();
        wordToPDF.docToPdf(new File("E:/logback.docx"), new File("C:/Users/admin/Desktop/ss/logback.pdf"));

        //excel 转 pdf
        wordToPDF.docToPdf(new File("E:/interface.xlsx"), new File("C:/Users/admin/Desktop/ss/interface.pdf"));

    }
}

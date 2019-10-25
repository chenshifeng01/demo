//package com.chen.jdk.basic.day02_file.filetoimage;
//
//
//import java.io.File;
//
//
///**
// * 使用  icepdf 进行转化
// * @author yangnuo
// * 创建时间：2017年3月16日
// */
//public class Test2_OfficeImage {
//
//    public static void main(String[] args) {
//        //word 转 pdf
//        OfficeToPDF wordToPDF = new OfficeToPDF();
//
//        String newpdfpath = "/Users/chenshifeng/Documents/project/idea/java/starsky-jdk-basic/src/main/resources/1.pdf";
//        wordToPDF.docToPdf(new File("/Users/chenshifeng/Documents/project/idea/java/starsky-jdk-basic/src/main/resources/1.docx"),
//                new File(newpdfpath));
//
//        PDFToImage pdf = new PDFToImage();
//        pdf.pdftoIamge(0.9f,newpdfpath, "/Users/chenshifeng/Documents/project/idea/java/starsky-jdk-basic/src/main/resources/pdfImage/");
//    }
//
//}

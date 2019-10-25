package com.chen.jdk.basic.day02_file.word;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * poi操作word读取包含分页
 */
public class PoiWordToPage_1 {

    public static void main(String[] args) throws Exception {
//        try {
//            OPCPackage opcPackage = POIXMLDocument.openPackage("/Users/chenshifeng/Documents/project/idea/java/starsky-jdk-basic/src/main/resources/1.docx");
//            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
//            String text2007 = extractor.getText();
//
//            System.out.println(text2007);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        WordExtractor doc = new WordExtractor(new FileInputStream("/Users/chenshifeng/Documents/project/idea/java/starsky-jdk-basic/src/main/resources/2.doc"));
//        int pages = doc.getSummaryInformation().getPageCount();//总页数
//        int wordCount = doc.getSummaryInformation().getWordCount();//总字符数
//        System.out.println ("pages=" + pages + " wordCount=" + wordCount);


        doxc();

//        try {
//
//            FileInputStream fileInputStream = new FileInputStream("E:\\下载\\table1.docx");
//            XWPFDocument document = new XWPFDocument(fileInputStream);
//            document.getBodyElements();
//
//            List<XWPFTable> tables = document.getTables();
//
//
//            for (XWPFTable table : tables) {
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }



    public static void doxc() throws InvalidFormatException {
        String importPath = "/Users/chenshifeng/Documents/project/idea/java/starsky-jdk-basic/src/main/resources/1.docx";
        String absolutePath = "/Users/chenshifeng/Documents/project/idea/java/starsky-jdk-basic/src/main/resources/copy/";
        try {
            FileInputStream inputStream = new FileInputStream(importPath);
            XWPFDocument xDocument = new XWPFDocument(inputStream);
            List<XWPFParagraph> paragraphs = xDocument.getParagraphs();
            List<XWPFPictureData> pictures = xDocument.getAllPictures();
            Map<String, String> map = new HashMap<String, String>();
            for(XWPFPictureData picture : pictures){

                String id = picture.getParent().getRelationId(picture);
                File folder = new File(absolutePath);
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                String rawName = picture.getFileName();
                String fileExt = rawName.substring(rawName.lastIndexOf("."));
                String newName = System.currentTimeMillis() + UUID.randomUUID().toString() + fileExt;
                File saveFile = new File(absolutePath + File.separator + newName);
                @SuppressWarnings("resource")
                FileOutputStream fos = new FileOutputStream(saveFile);
                fos.write(picture.getData());
                System.out.println(id);
                System.out.println(saveFile.getAbsolutePath());
                map.put(id, saveFile.getAbsolutePath());
            }
            String text = "";
            for(XWPFParagraph paragraph : paragraphs){
                //System.out.println(paragraph.getParagraphText());
                List<XWPFRun> runs = paragraph.getRuns();
                for(XWPFRun run : runs){
                    /*System.out.println(run.getCTR().xmlText());*/
                    if(run.getCTR().xmlText().indexOf("<w:drawing>")!=-1){
                        String runXmlText = run.getCTR().xmlText();
                        int rIdIndex = runXmlText.indexOf("r:embed");
                        int rIdEndIndex = runXmlText.indexOf("/>", rIdIndex);
                        String rIdText = runXmlText.substring(rIdIndex, rIdEndIndex);
                        System.out.println(rIdText.split("\"")[1].substring("rId".length()));
                        String id = rIdText.split("\"")[1];
                        System.out.println(map.get(id));
                        text = text +"<img src = '"+map.get(id)+"'/>";
                    }else{
                        text = text + run;
                    }
                }
            }
            System.out.println(text);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}

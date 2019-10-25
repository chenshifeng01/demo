package com.chen.jdk.basic.day02_file.word;

import org.apache.poi.hwpf.HWPFDocumentCore;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.converter.WordToHtmlUtils;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * 本实例代码，演示将word文本全部取出转换成html
 */
public class wordTohtml_01 {

    public static void main(String[] args) throws Exception {
        HWPFDocumentCore wordDocument = WordToHtmlUtils.loadDoc(new FileInputStream("/Users/chenshifeng/Documents/project/idea/java/starsky-jdk-basic/src/main/resources/2.doc"));

        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder()
                        .newDocument());
        wordToHtmlConverter.processDocument(wordDocument);
        Document htmlDocument = wordToHtmlConverter.getDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(out);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        out.close();

        String result = new String(out.toByteArray());
        Word2Html.writeFile(result, "/Users/chenshifeng/Documents/project/idea/java/starsky-jdk-basic/src/main/resources/upfile/transferFile/3.htm");

        System.out.println(result);
    }
}

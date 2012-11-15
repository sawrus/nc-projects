package com.tools.xml;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class XmlTools
{
    public static Document parseXmlString(String s) throws IOException, SAXException, ParserConfigurationException
    {
        StringReader stringReader = new StringReader(s);
        InputSource inputSource = new InputSource(stringReader);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(inputSource);
    }
}

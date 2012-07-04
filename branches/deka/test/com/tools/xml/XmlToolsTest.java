package com.tools.xml;

import junit.framework.TestCase;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlToolsTest extends TestCase
{
    private static final String TEST_NC_PROJECTS_XML =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<module type=\"JAVA_MODULE\" version=\"4\">\n" +
            "  <component name=\"NewModuleRootManager\" inherit-compiler-output=\"true\">\n" +
            "    <exclude-output />\n" +
            "    <content url=\"file://$MODULE_DIR$\">\n" +
            "      <sourceFolder url=\"file://$MODULE_DIR$/src\" isTestSource=\"false\" />\n" +
            "    </content>\n" +
            "    <orderEntry type=\"inheritedJdk\" />\n" +
            "    <orderEntry type=\"sourceFolder\" forTests=\"false\" />\n" +
            "    <orderEntry type=\"library\" name=\"global\" level=\"application\" />\n" +
            "  </component>\n" +
            "</module>";

    public void testParseXmlString() throws Exception
    {
        try
        {
            Document document = XmlTools.parseXmlString(TEST_NC_PROJECTS_XML);
            NodeList componentChildNodes = document.getFirstChild()/*<module>*/
                    .getChildNodes().item(1)/*<component>*/
                    .getChildNodes();

            /*Find count children nodes with NodeName equal "orderEntry"*/
            String orderEntryTagName = "orderEntry";

            /* Expected result*/
            int countOrderEntryTagsER = 3;

            /* Actual result*/
            int countOrderEntryTagsAR = getCountTagsByName(componentChildNodes, orderEntryTagName);

            assertEquals(countOrderEntryTagsER, countOrderEntryTagsAR);
        }
        catch (Exception e)
        {
            fail(e.getMessage());
        }
    }

    private int getCountTagsByName(NodeList childNodes, String tagName)
    {
        int countTags = 0;
        for (int i = 0; i < childNodes.getLength(); i++)
        {
            String nodeName = childNodes.item(i).getNodeName();
            if (tagName.equals(nodeName))
            {
                countTags++;
            }
        }
        return countTags;
    }
}
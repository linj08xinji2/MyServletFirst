package com.meixin.xml; 

import java.io.File; 
import java.io.IOException; 
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.w3c.dom.Node; 
import org.w3c.dom.NodeList; 
import org.xml.sax.SAXException; 

public class XMLParse 
{ 
  Document document = null; 

  NodeList allNode = null; 

  // ���캯������ʼ��Document���� 
  public XMLParse() 
  { 
    // ָ��File�ļ� 
    File file = new File("MyXml.xml"); 

    // ����DocumentBuilderFactory���� 
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory 
        .newInstance(); 
    DocumentBuilder builder; 
    try 
    { 
      // ����DocumentBuilder���� 
      builder = builderFactory.newDocumentBuilder(); 
      // ��DocumentBuilder�����parse���������ļ�����Document���� 
      document = builder.parse(file); 
      allNode = document.getChildNodes(); 
        
      // ����1���ҳ�����person��ǩ������NodeList 
      NodeList person = document.getElementsByTagName("person"); 
      // ���������peron��ǩ�е����Ժ�ֵ 
      showByCondition(person); 

      // ����2���������нڵ� 
      searchAndShow(allNode); 

      // ����3������ǩ��������� 
      this.SearchByCondition(person); 
    } 
    catch (ParserConfigurationException e) 
    { 
      e.printStackTrace(); 
    } 
    catch (SAXException e) 
    { 
      e.printStackTrace(); 
    } 
    catch (IOException e) 
    { 
      System.err.println("�Ҳ�����ָ�����ļ���"); 
      e.printStackTrace(); 
    } 
  } 

  // ����Ѱ�ұ��� 
  public void searchAndShow(NodeList allNode) 
  { 
    System.out.println(); 
    System.out.println("------searchAndShow������-------"); 
    for (int i = 0; i < allNode.getLength(); i++) 
    { 
      // �õ�һ���ڵ㣬��Ҫǿ��ת��ΪElement������Node��Element�ĸ��� 
      Node node = allNode.item(i); 
      if (!node.getNodeName().equals("#text")) 
      { 
        System.out.println("�ڵ����ƣ�" + node.getNodeName()); 
      } 
      // System.out.println(element.getAttribute("")); 

      if (node.getChildNodes().getLength() > 3) 
      { 
        // �������ӽڵ㣬��ݹ���� 
        System.out.println("�˽ڵ������Ԫ�أ�"); 
        searchAndShow(node.getChildNodes()); 
      } 
      else 
      { 
        // ���������ӽڵ㣬������ڵ��е����� 
        if (!node.getTextContent().trim().equals("") 
            && node.getTextContent() != null) 
        { 
          System.out.println("�ڵ�ֵ��" + node.getTextContent()); 
        } 
      } 
    } 
  } 

  // ��������� 
  public void showByCondition(NodeList allNode) 
  { 
    System.out.println(); 
    System.out.println("------showByCondition������-------"); 
    Element element; 
    // �Է������������нڵ���б��� 
    for (int i = 0; i < allNode.getLength(); i++) 
    { 
      // ���һ��Ԫ�� 
      element = (Element) allNode.item(i); 
      // ������Ԫ�ص�personid���� 
      System.out.println(element.getAttribute("personid")); 
      // ��Ԫ�����ӽڵ㣬��ȡ�����ӽڵ㣬����һ��personList 
      NodeList personList = element.getChildNodes(); 
      // ���������ӽڵ� 
      for (int j = 0; j < personList.getLength(); j++) 
      { 
        // ���ӽڵ�����Ʋ�Ϊ#text���������#textΪ������ǩ 
        if (!personList.item(j).getNodeName().equals("#text")) 
        { 
          // ����ڵ����ơ��ڵ�ֵ 
          System.out.println(personList.item(j).getNodeName() + ":" 
              + personList.item(j).getTextContent()); 
        } 
      } 
    } 
  } 

  // ����ǩ��Ѱ�ҽڵ� 
  public void SearchByCondition(NodeList allNode) 
  { 
    System.out.println(); 
    System.out.println("------SearchByCondition������-------"); 
    Element element; 
    // �Է������������нڵ���б��� 
    for (int i = 0; i < allNode.getLength(); i++) 
    { 
      // ��document����������name��ǩ���õ�һ����ǩ�����ֵ 
      String name = document.getElementsByTagName("name").item(i) 
          .getTextContent(); 
      System.out.println("������" + name); 

      // ��document����������tel��ǩ���õ�һ����ǩ�����ֵ 
      String tel = document.getElementsByTagName("tel").item(i) 
          .getTextContent(); 
      System.out.println("�绰��" + tel); 

      // //��document����������tel��ǩ���õ�һ����ǩ�����ֵ 
      String sex = document.getElementsByTagName("email").item(i) 
          .getTextContent(); 
      System.out.println("email��" + sex); 
      System.out.println("==================="); 
    } 
  } 

  public static void main(String[] args) 
  { 
    new XMLParse(); 
  } 
} 
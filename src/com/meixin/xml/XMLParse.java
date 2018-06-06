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

  // 构造函数，初始化Document对象 
  public XMLParse() 
  { 
    // 指定File文件 
    File file = new File("MyXml.xml"); 

    // 建立DocumentBuilderFactory对象 
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory 
        .newInstance(); 
    DocumentBuilder builder; 
    try 
    { 
      // 建立DocumentBuilder对象 
      builder = builderFactory.newDocumentBuilder(); 
      // 用DocumentBuilder对象的parse方法引入文件建立Document对象 
      document = builder.parse(file); 
      allNode = document.getChildNodes(); 
        
      // 测试1：找出所有person标签，返回NodeList 
      NodeList person = document.getElementsByTagName("person"); 
      // 按条件输出peron标签中的属性和值 
      showByCondition(person); 

      // 测试2：遍历所有节点 
      searchAndShow(allNode); 

      // 测试3：按标签名查找输出 
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
      System.err.println("找不到你指定的文件！"); 
      e.printStackTrace(); 
    } 
  } 

  // 例：寻找遍历 
  public void searchAndShow(NodeList allNode) 
  { 
    System.out.println(); 
    System.out.println("------searchAndShow输出结果-------"); 
    for (int i = 0; i < allNode.getLength(); i++) 
    { 
      // 得到一个节点，需要强制转换为Element，这里Node是Element的父类 
      Node node = allNode.item(i); 
      if (!node.getNodeName().equals("#text")) 
      { 
        System.out.println("节点名称：" + node.getNodeName()); 
      } 
      // System.out.println(element.getAttribute("")); 

      if (node.getChildNodes().getLength() > 3) 
      { 
        // 若包含子节点，则递归遍历 
        System.out.println("此节点包含子元素！"); 
        searchAndShow(node.getChildNodes()); 
      } 
      else 
      { 
        // 若不包含子节点，则输出节点中的内容 
        if (!node.getTextContent().trim().equals("") 
            && node.getTextContent() != null) 
        { 
          System.out.println("节点值：" + node.getTextContent()); 
        } 
      } 
    } 
  } 

  // 按条件输出 
  public void showByCondition(NodeList allNode) 
  { 
    System.out.println(); 
    System.out.println("------showByCondition输出结果-------"); 
    Element element; 
    // 对符合条件的所有节点进行遍历 
    for (int i = 0; i < allNode.getLength(); i++) 
    { 
      // 获得一个元素 
      element = (Element) allNode.item(i); 
      // 输出这个元素的personid属性 
      System.out.println(element.getAttribute("personid")); 
      // 此元素有子节点，获取所有子节点，返回一个personList 
      NodeList personList = element.getChildNodes(); 
      // 遍历所有子节点 
      for (int j = 0; j < personList.getLength(); j++) 
      { 
        // 若子节点的名称不为#text，则输出，#text为反／标签 
        if (!personList.item(j).getNodeName().equals("#text")) 
        { 
          // 输出节点名称、节点值 
          System.out.println(personList.item(j).getNodeName() + ":" 
              + personList.item(j).getTextContent()); 
        } 
      } 
    } 
  } 

  // 按标签名寻找节点 
  public void SearchByCondition(NodeList allNode) 
  { 
    System.out.println(); 
    System.out.println("------SearchByCondition输出结果-------"); 
    Element element; 
    // 对符合条件的所有节点进行遍历 
    for (int i = 0; i < allNode.getLength(); i++) 
    { 
      // 用document来查找所有name标签，得到一个标签后输出值 
      String name = document.getElementsByTagName("name").item(i) 
          .getTextContent(); 
      System.out.println("姓名：" + name); 

      // 用document来查找所有tel标签，得到一个标签后输出值 
      String tel = document.getElementsByTagName("tel").item(i) 
          .getTextContent(); 
      System.out.println("电话：" + tel); 

      // //用document来查找所有tel标签，得到一个标签后输出值 
      String sex = document.getElementsByTagName("email").item(i) 
          .getTextContent(); 
      System.out.println("email：" + sex); 
      System.out.println("==================="); 
    } 
  } 

  public static void main(String[] args) 
  { 
    new XMLParse(); 
  } 
} 
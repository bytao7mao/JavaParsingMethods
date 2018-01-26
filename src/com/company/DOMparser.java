package com.company;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class DOMparser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("What would you like the " +
                    "file to be called?");
            String numeFisier = sc.nextLine();
            if(numeFisier==""){
                numeFisier = numeFisier + "fisierRandom";
            }
            if(!numeFisier.contains(".txt")){
                numeFisier+=".txt";
            }
            PrintWriter fisier = new PrintWriter(numeFisier);
            String continutFisier = "";

            File xmlFile = new File("C:\\Users\\Mariu\\Desktop\\ManipulateXML\\data\\cust.xml");





            DocumentBuilder builder =
                    DocumentBuilderFactory.newInstance().newDocumentBuilder();
            
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            factory.setIgnoringComments(true);
//            factory.setIgnoringElementContentWhitespace(true);
//            factory.setValidating(true);
//            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            continutFisier+="Root element :" + doc.getDocumentElement().getNodeName();

            NodeList nList = doc.getElementsByTagName("student");
            continutFisier+=("----------------------------");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                continutFisier+="\nCurrent Element :" + nNode.getNodeName();

                //checking if type is element
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    continutFisier+=" - Student roll no : "
                            + eElement.getAttribute("rollno") + "\n";


                    continutFisier+="FirstName: "
                            + eElement
                            .getElementsByTagName("firstname")
                            .item(0)
                            .getTextContent();


                    continutFisier+=" LastName: "
                            + eElement
                            .getElementsByTagName("lastname")
                            .item(0)
                            .getTextContent();


                    continutFisier+=" Nickname: "
                            + eElement
                            .getElementsByTagName("nickname")
                            .item(0)
                            .getTextContent();


                    continutFisier+="Marks: "
                            + eElement
                            .getElementsByTagName("marks")
                            .item(0)
                            .getTextContent();
                }
            }
            continutFisier+="\nTotal number of nodes: " + nList.getLength();
            fisier.print(continutFisier);
            fisier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

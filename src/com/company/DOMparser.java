package com.company;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import com.sun.org.apache.xerces.internal.xni.parser.XMLDocumentSource;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class DOMparser {



    public static void main(String[] args) {
//        Path p = Paths.get("cust.xml");
//        Path folder = p.getParent();
//        System.out.println(p.getParent());
//        String file = new File("C:\\Users\\tao\\Desktop\\JAVA\\ManipulateXML\\data\\cust.xml").getParent();
//        System.out.println(file);
//        System.out.println("File path: " + new File("cust.xml").getAbsolutePath());
        Scanner sc = new Scanner(System.in);

            try {
                System.out.println("What would you like the " +
                        "file to be called?");
                String numeFisier = sc.nextLine();
                if (numeFisier.equals("")) {
                    numeFisier = numeFisier + "fisierRandom";
                }
                if (!numeFisier.contains(".txt")) {
                    numeFisier += ".txt";
                }
                PrintWriter fisier = new PrintWriter(numeFisier);
                String continutFisier = "";

                //get the path to cust.xml
                String replace = String.format("\"");
                String tempFileString = String.valueOf(new File(System.getProperty("user.dir") +"\\"+ "cust.xml"));
                String y = new File("cust.xml").getAbsolutePath().replace("\\", "\\\\\\");
//                String x = new File("cust.xml").getCanonicalPath().replaceAll(replace, File.separator);
//                System.out.println(tempFileString);
//                System.out.println(x);
//                System.out.println(tempFileString);
//                DOMparser.class.getResource...()
//                String tempFileString = new File("cust.xml").getAbsolutePath();

//                InputStream in = Main.class.getClassLoader().getResourceAsStream("cust.xml");

                URL u = DOMparser.class.getResource("/cust.xml");
                System.out.println(u.toString());
                File xmlFile = new File(u.toString());





                DocumentBuilder builder =
                        DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            factory.setIgnoringComments(true);
//            factory.setIgnoringElementContentWhitespace(true);
//            factory.setValidating(true);
//            DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(xmlFile);
                doc.getDocumentElement().normalize();

                //  <class> tag is root element
                continutFisier += "Root element: " + doc.getDocumentElement().getNodeName();


                NodeList list = doc.getElementsByTagName("student");
                for (int i = 0; i < list.getLength(); i++) {
                    Node node = list.item(i);
                    continutFisier += "\nCurrent Element :" + node.getNodeName();

                    //checking if type is element
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element child = (Element) node;
                        continutFisier += " - Student roll no : "
                                + child.getAttribute("rollno") + "\n";

                        continutFisier += "FirstName: "
                                + child.getElementsByTagName("firstname").item(0)
                                .getTextContent();

                        continutFisier += " LastName: "
                                + child.getElementsByTagName("lastname").item(0)
                                .getTextContent();

                        continutFisier += " Nickname: "
                                + child.getElementsByTagName("nickname").item(0)
                                .getTextContent();

                        continutFisier += "Marks: "
                                + child.getElementsByTagName("marks").item(0)
                                .getTextContent();
                    }
                }
                continutFisier += "\nTotal number of nodes: " + list.getLength();
                fisier.print(continutFisier);
                fisier.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

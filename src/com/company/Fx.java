package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.PrintWriter;
import java.lang.management.BufferPoolMXBean;
import java.util.Scanner;

public class Fx extends Application {
    Button button;
    TextField filename;
    TextField pathName;
    Scene scene;

    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception{


        Text scenetitle = new Text("get XML data");
        Label f = new Label("file name: ");
        filename = new TextField();
        Label path = new Label("path: ");
        pathName = new TextField();

        button = new Button("Done");
        HBox hbtn = new HBox(10);
        hbtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbtn.getChildren().add(button);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        grid.add(scenetitle, 0,0,2,1);
        grid.add(f,0,1);
        grid.add(filename,1,1);
        grid.add(path,0,2);
        grid.add(pathName,1,2);
        grid.add(hbtn,1,4);
        grid.setGridLinesVisible(false);


        scene = new Scene(grid, 300, 275);

        primaryStage.setTitle("Manipulating XML");
        primaryStage.setScene(scene);
        primaryStage.show();




        button.setOnAction(event -> {


                    try {
                        PrintWriter fisier = new PrintWriter(filename.getText());
                        String continutFisier = "";

                        //File xmlFile = new File("C:\\Users\\Mariu\\Desktop\\ManipulateXML\\data\\cust.xml");
                        File xmlFile = new File(pathName.getText());

                        DocumentBuilder builder =
                                DocumentBuilderFactory.newInstance().newDocumentBuilder();
                        Document doc = builder.parse(xmlFile);
                        doc.getDocumentElement().normalize();

                        continutFisier += "Root element:" + doc.getDocumentElement().getNodeName() + ">";

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
            primaryStage.close();
        });
    }


}

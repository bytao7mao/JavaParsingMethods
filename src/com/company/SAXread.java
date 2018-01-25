package com.company;

import java.util.List;

public class SAXread {
    public static void main(String[] args) throws Exception{
        String filename = Main.DATADIR + "customers.xml";

        SAXCustomerHandler saxHandler = new SAXCustomerHandler();
        List<Customer> data = saxHandler.readDataFromXML(filename);

        for (Customer c:data) {
            System.out.println("Customer " + c);
        }
        System.out.println("Number of customers: " + data.size());
    }
}

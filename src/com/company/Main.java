package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.math.BigDecimal;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String DATADIR = "data/";
    public static final int SMALL = 10;
    public static final int MEDIUM = 1000;
    public static final int LARGE = 50000;

    public static void main(String[] args) {
        Stopwatch watch = new Stopwatch().start("Getting data from JSON");
        List<Customer> data = getData(SMALL);
        System.out.println("Returned: " + data.size());
        for (int i=0; i < Math.min(data.size(), 10);i++){
            System.out.println((Customer)data.get(i));
        }
        watch.stop();
    }

    public static List<Customer> getData(int limit){
        //		Decide which file to read from.
        String filename = null;
        if (limit == LARGE){
            filename = DATADIR + "customersLarge.json";
        } else {
            filename = DATADIR + "customers.json";
        }

        //		Parse JSON file and get the data
        JSONArray inputData = null;
        JSONParser parser = new JSONParser();
        try {
            JSONObject obj = (JSONObject)parser.parse(new FileReader(filename));
            inputData = (JSONArray) obj.get("result");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
        //		Create a List to contain typed objects
        List<Customer> outputData = new ArrayList<>();

 //		Loop through the array up to requested limit,
//		copy JSON objects to ArrayList of POJO's
        for (int i=0; i < limit; i++){
            JSONObject item = (JSONObject)inputData.get(i);
            Customer cust = new Customer();

            try{
                cust.setId((Number) item.get(Customer.ID));
                cust.setName((String)item.get(Customer.NAME));
                cust.setPhone((String)item.get(Customer.PHONE));
                cust.setAbout((String)item.get(Customer.ABOUT));
                cust.setAge((Number) item.get(Customer.AGE));
                cust.setBalance((String) item.get(Customer.BALANCE));
                cust.setActive((Boolean)item.get(Customer.ACTIVE));
            }catch (Exception e){
                e.printStackTrace();
            }


            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            String joined = (String) item.get(Customer.JOINED);
            try {
                cust.setJoined(df.parse(joined));
            } catch (java.text.ParseException e){
                e.printStackTrace();
            }
            outputData.add(cust);
        }
        //		All done, return the data
        return outputData;
    }
}

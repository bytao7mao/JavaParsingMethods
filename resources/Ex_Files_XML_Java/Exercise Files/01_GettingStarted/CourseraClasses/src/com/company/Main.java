package com.company;
import com.company.meth;
public class Main {


    public static void main(String[] args) {

        staticcs unu = new staticcs();
        staticcs doi = new staticcs();
        staticcs trei = new staticcs();



//        System.out.println(lastDigit(233));
//        String x = "abra().cadabra";
//        String y = com.company.caesarphy.normalizeText(x);
//        String encrypt = com.company.caesarphy.chiper(y);
//        System.out.println(encrypt);
//
//        System.out.println(fact(5));


    }
    //returns last digit
    public static int lastDigit(int num) {
        return Math.abs(num % 10);
    }



    public static int fact(int num){
        if (num == 1){return 1;}else{return num*fact(num-1);}
    }


}

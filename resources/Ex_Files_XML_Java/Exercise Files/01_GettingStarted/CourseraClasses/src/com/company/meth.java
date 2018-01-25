package com.company;

import java.util.Scanner;

public class meth {


    public static String normalize() {
        Scanner input = new Scanner(System.in);
        String text1 = input.nextLine();
        text1 = text1.replace(" ","");
        text1 = text1.replaceAll("[/|!?.,()\"'=;:_^~`´]", "");
        text1 = text1.toUpperCase();
        return text1;

    }
}

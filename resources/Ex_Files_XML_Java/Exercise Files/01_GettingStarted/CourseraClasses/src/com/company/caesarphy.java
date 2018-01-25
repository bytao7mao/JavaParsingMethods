package com.company;
import java.util.Arrays;
import java.lang.String;
public class caesarphy {
    //simplest algorithm for encrypt
    public static String normalizeText(String text){
        // normalizedText;

        text = text.replace(" ","");
        text = text.replaceAll("[/|!?.,()\"'=;:_^~`´]", "");
        text= text.toUpperCase();

        return text;
    }
    public static String chiper(String msg){
        String s = "";
        int len = msg.length();
        for (int x=0; x < len; x++){
            char c = (char)(msg.charAt(x) + 1);
            if (c > 'z')
                s += (char)(msg.charAt(x)-(26-1));
            else
                s += (char)(msg.charAt(x)+1);
        }
        return s;
    }

}

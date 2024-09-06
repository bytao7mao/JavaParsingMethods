package com.company;

public class staticcs {
    static int number = 0; //isi pastreaza valoarea la fiecare instantiere a clasei

    public staticcs(){
        number++;
        System.out.println(number);
    }

}

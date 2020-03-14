package com.company;
import java.util.Random;
public class randomarray {
    public static void main(String[] args) {
        Random rd = new Random(); // creating Random object
        int sum = 0;
        for (int i = 1; i < 701; i++) {

             int rand = rd.nextInt(1000); // storing random integers in an array
             int rand1 = rd.nextInt(1000);
             sum = sum + rand1;
            System.out.println(" " +i + " " +rand + " " +rand1);


            //System.out.print(" " +rand); // printing each array element
           // System.out.print(" " +rand1);

        }
        System.out.println(" " +sum);
    }
}


package com.company;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.File;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file =  new File("//Users/priyankapandey/KnapsackAlgo/src/com/company/input1000.txt/");
        Scanner scanner = new Scanner(file);
        int count = scanner.nextInt();
        int sum = 0;
        int sum1 = 0;
        List<Item> items = new LinkedList<Item>();
        for (int i = 0; i < count; i++) {
            Item item = new Item();
            item.label = scanner.nextInt();
            item.value = scanner.nextDouble();
            item.weight = scanner.nextDouble();
            items.add(item);
           sum += item.value;
           sum1 += item.weight;
        }

        int capacity = scanner.nextInt();

        List<KnapsackSolver> solvers = new ArrayList<KnapsackSolver>();

        if (items.size() <= 1000)

        solvers.add(new Greedy(items, capacity));
        solvers.add(new DynamicProgramming(items, capacity));


        for (KnapsackSolver solver : solvers) {
            System.out.println(solver.solve());

        }
        System.out.println("Total Profit : " +sum);
        System.out.println("Total Weight :" +sum1);
        System.out.println("size" +items.size());
    }
}
package com.company;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.File;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file =  new File("//Users/priyankapandey/0-1-Knapsack/KnapsackAlgo/src/com/company/input1000.txt/");
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

        int capacity = 10000;
        System.out.println("Capacity" + capacity);
        System.out.println("Item length" + items.size());

        List<KnapsackSolver> solvers = new ArrayList<KnapsackSolver>();
        System.out.println("-------------Calliing Greedy Approach------------");
        Greedy G = new Greedy(items, capacity);
        KnapsackSolution ksGreedy = G.solve();
        System.out.println("Best Profit: " + ksGreedy.value + ", Total Weight utilized: " + ksGreedy.weight);
        System.out.println("-------------Greedy Approach Ends------------");
        System.out.println("");

        System.out.println("-------------Calliing Psuedo Polynomial(Decision Algorithm NP-Complete) Approach------------");
        DynamicProgramming dp = new DynamicProgramming(items, capacity);
        KnapsackSolution ksDp = dp.solve();
        System.out.println("Best Profit: " + ksDp.value + ", Total Weight utilized: " + ksDp.weight);
        System.out.println("-------------NP Complete Ends------------");
        System.out.println("");
        System.out.println("-------------Calliing Polynomial(Appriximation Algorithm NP-Hard) Approach------------");

        double scaleFactor = dp.GetScalingFactor(items, 0.5);
        List<Item> scaledUpItems = dp.ScaleItemValues(items, scaleFactor);
        DynamicProgramming dp2 = new DynamicProgramming(scaledUpItems, capacity);

        KnapsackSolution ksFtpas = dp2.solve();
        System.out.println("Total Weight utilized: " + ksDp.weight);
        double ftpasResult = ksFtpas.value * scaleFactor;
        System.out.println("FTPAS Result: " + ksFtpas.value + " * " +  scaleFactor + " = " + ftpasResult);

        System.out.println("-------------NP Hard Ends------------");





    }
}





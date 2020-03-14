package com.company;

import java.util.*;

public class Greedy extends KnapsackSolver {

    public Greedy(List<Item> items, int capacity) {
        super(items, capacity);
    }

    @Override
    public KnapsackSolution solve() {

        KnapsackSolution greedy = new KnapsackSolution();
        long start = System.currentTimeMillis();
        greedy.items = new ArrayList<Item>(items);

        Collections.sort(greedy.items, Item.byRatio());

        double capUsed = 0;
        double value = 0;
        int i;


        for (i = 0; i < greedy.items.size(); i++) {
            Item item = greedy.items.get(i);
            if (capUsed + item.weight > capacity) break;

            capUsed += item.weight;
            value += item.value;
        }

        greedy.items = greedy.items.subList(0, i);
        greedy.weight = capUsed;
        greedy.value = value;
        greedy.approach = "Greedy solution (not necessarily optimal)";
        //System.out.println("capacity:" +capacity);

        long end = System.currentTimeMillis();
        System.out.println("search takes " +  (end - start) + "ms");
        // Calculate the used memory
        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);

        return greedy;
    }
}

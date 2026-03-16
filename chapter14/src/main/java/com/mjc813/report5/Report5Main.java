package com.mjc813.report5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Report5Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String input = sc.nextLine();
            String[] split = input.split(",");
            int[] intArray = Arrays.asList(split).stream().mapToInt(Integer::parseInt).toArray();
            List<Integer> list = Arrays.stream(intArray).boxed().collect(Collectors.toList());

            Thread threadOfSum = new Thread(new ThreadOfSum(list));
            Thread threadOfAvg = new Thread(new ThreadOfAvg(list));
            Thread threadOfOdd = new Thread(new ThreadOfOdd(list));
            Thread threadOfPrintASC = new Thread(new ThreadOfPrintASC(list));
            Thread threadOfPrintDescEven = new Thread(new ThreadOfPrintDescEven(list));

            threadOfSum.start();
            threadOfAvg.start();
            threadOfOdd.start();
            threadOfPrintASC.start();
            threadOfPrintDescEven.start();
        }
    }
}

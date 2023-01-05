package org.example;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
            try {
                int a = 90;
                int b = 3;
                System.out.println(a / b);
                printSum(23, 234);
                int[] abc = { 1, 2 };
                abc[1] = 9;
                System.out.println(Arrays.toString(abc));
            } catch (ArithmeticException ex) {
                throw new ArithmeticException(ex.getMessage());
            } catch (IndexOutOfBoundsException ex) {
                throw new IndexOutOfBoundsException(ex.getMessage());
            }
        }
        public static void printSum(Integer a, Integer b){
            System.out.println(a + b);
        }

    }


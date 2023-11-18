package com.coding.stream.api.Entity;

import java.util.Arrays;
import java.util.Scanner;

public class Division {

    public void except() throws ArithmeticException{
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Welcome to Exception");

            System.out.println("Enter first Number: ");
            int a = scanner.nextInt();
            System.out.println("Enter second Number: ");
            int b = scanner.nextInt();
            int result = a / b;
            System.out.println("Result is :" + result);
        } catch (ArithmeticException a) {
            System.out.println("Arithmetic");
            throw a;
        }
//        try {
//            System.out.println("Enter the Array size:");
//            int size = scanner.nextInt();
//            int[] arr = new int[size];
//            System.out.println("please enter the element :");
//            int element = scanner.nextInt();
//            System.out.println("enter the position:");
//            int position = scanner.nextInt();
//            arr[position] = element;
//            System.out.println("output is :" + Arrays.toString(arr));
//        } catch (IndexOutOfBoundsException b) {
//            System.out.println("Index out of bound");
//        } catch (NegativeArraySizeException c) {
//            System.out.println("No negative");
//        }
        finally {
            System.out.println("the end");
        }

    }

}

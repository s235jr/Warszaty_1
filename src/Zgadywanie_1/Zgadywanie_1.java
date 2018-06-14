package Zgadywanie_1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Zgadywanie_1 {


    public static void main(String[] args) {

        Random rand = new Random();
        int toFind = rand.nextInt(100) + 1;

        System.out.println("Zgadnij liczbę!");
        Scanner scanner = new Scanner(System.in);

        int input = 0;
        try {
            do {
                input = scanner.nextInt();
                if (input < toFind) {
                    System.out.println("Za mało!");
                } else if (input > toFind) {
                    System.out.println("Za dużo!");
                } else {
                    System.out.println("Zgadłeś!");
                }
            }
            while (input != toFind);

        } catch (InputMismatchException e) {
            System.out.println("Niepoprawny format liczby!");
        }
    }
}

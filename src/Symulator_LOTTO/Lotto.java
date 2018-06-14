package Symulator_LOTTO;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    public static void main(String[] args) {

        int[] table = generatePlayerValue();
        int[] randomTable = generateRandomTable();

        System.out.println(Arrays.toString(table) + " - Tablica liczb gracza.");
        System.out.println(Arrays.toString(randomTable) + " - Tablica wylosowanych liczb");

        checkResult(table, randomTable);
    }

    private static int[] generatePlayerValue() {
        int[] table = new int[6];

        for (int i = 0; i < table.length; i++) {

            inputNumber(table, i);

        }

        Arrays.sort(table);
        return table;
    }

    private static void checkResult(int[] table, int[] randomTable) {
        int goodShot = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < randomTable.length; j++) {
                if (table[i] == randomTable[j]) {
                    goodShot++;
                }
            }
        }
        if (goodShot >= 2) {
            System.out.println("Gracz trafił: " + goodShot + " razy!");
        }
    }

    private static int[] generateRandomTable() {

        int[] randomTable = new int[6];


        for (int i = 0; i < randomTable.length; i++) {
            generateRandomValue(randomTable, i);
        }
        Arrays.sort(randomTable);
        return randomTable;
    }

    private static void generateRandomValue(int[] randomTable, int i) {
        Random rand = new Random();
        randomTable[i] = rand.nextInt(49) + 1;
        for (int j = 0; j < i; j++) {
            if (randomTable[i] == randomTable[j]) {
                generateRandomValue(randomTable, i);
            }
        }
    }

    private static void inputNumber(int[] table, int i) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę nr " + (i + 1));

        try {
            table[i] = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("To nie jest liczba!");
        }

        for (int j = 0; j < i; j++) {
            if (table[i] == table[j]) {
                System.out.println("Podałeś już taką liczbę!");
                inputNumber(table, i);
            }
        }

        if (table[i] < 1 || table[i] > 49) {
            System.out.println("Liczba poza dopuszczalnym zakresem!");
            inputNumber(table, i);
        }

    }
}

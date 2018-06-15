package KostkaDoGry;

import java.util.Arrays;
import java.util.Random;

public class Kostka {

    public static void main(String[] args) {

        String input = "2D4-5";

        int[] values = generateValue(input);
        int result = getResult(values);
        System.out.println(result);

    }

    private static int getResult(int[] values) {
        int sumRandom = 0;
        Random random = new Random();

        for (int i = 0; i < values[0]; i++) {
            sumRandom = sumRandom + random.nextInt(values[1]) + 1;
        }

        return sumRandom + values[2];
    }

    private static int[] generateValue(String input) {
        int[] values = new int[3];
        String[] firstSplit = input.split("D");

        if (firstSplit[0].isEmpty()) {
            values[0] = 1;
        } else {
            values[0] = Integer.parseInt(firstSplit[0]);
        }

        if (firstSplit[1].contains("+")) {

            String[] secondSplit = firstSplit[1].split("\\+");
            values[1] = Integer.parseInt(secondSplit[0]);
            values[2] = Integer.parseInt(secondSplit[1]);
        } else if (firstSplit[1].contains("-")) {

            String[] secondSplit = firstSplit[1].split("\\-");
            values[1] = Integer.parseInt(secondSplit[0]);
            values[2] = -Integer.parseInt(secondSplit[1]);

        } else {
            values[1] = Integer.parseInt(firstSplit[1]);
            values[2] = 0;
        }
        System.out.println(Arrays.toString(values));
        return values;
    }

}

package Zgadywanie_2;

import java.util.Scanner;

public class Zgadywanie_2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int min = 0;
        int max = 1000;

        String answer = "";

        while (!answer.equals("trafiłeś")) {
            int shot = (max - min) / 2 + min;
            System.out.println("Zgaduje: " + shot);
            System.out.println("Jak mi poszło? Odpowiedz: więcej / mniej / trafiłęś");
            answer = scanner.next();

            switch (answer) {
                case "więcej":
                    min = shot;
                    break;
                case "mniej":
                    max = shot;
                    break;
                case "trafiłeś":
                    System.out.println("Zgadłeś!");
                    break;
                default:
                    System.out.println("Chyba źle mi podpowiadasz!");
            }
        }

    }


}

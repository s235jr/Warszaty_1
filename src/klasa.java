import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class klasa {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int liczba = 0;

        while (liczba == 0) {

            System.out.println("Zgadnij liczbę");

            try {
                liczba = scanner.nextInt();
                return;
            } catch (InputMismatchException e) {
                System.out.println("To nie jest liczba");
            }
        }

        System.out.println(liczba);

    }


}

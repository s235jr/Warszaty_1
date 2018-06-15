package Wyszukiwarka;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Wyszukiwarka {

    public static void main(String[] args) {

        String url = "http://www.onet.pl/";
        String fileName = "popular_words.txt";
        String filtredFile = "filtered_popular_words.txt";
        String[] censor = {"Maroko", "Gwiazdor", "polski", "prasowa", "przełomu"};

        isFileExist(fileName);
        isFileExist(filtredFile);

        Connection connection = Jsoup.connect(url);

        try {

            Document document = connection.get();
            Elements doc = document.select("span.title");
            String docWithoutHTML = doc.html();
            writeToFile(fileName, docWithoutHTML);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            Scanner scan = new Scanner(new File(fileName));

            while (scan.hasNext()) {

                String input = scan.next();
                boolean isToWrite = true;

                for (int i = 0; i < censor.length; i++) {

                    if (input.equals(censor[i])) {
                        isToWrite = false;
                    }
                }

                try {
                    FileWriter writer = new FileWriter(filtredFile, true);
                    if (isToWrite) {
                        writer.append(input + " ");
                        writer.close();
                    }
                } catch (IOException e) {
                    System.out.println("Nie mogłem zapisać do pliku!");
                }
            }


        } catch (IOException e) {
            System.out.println("Nie udało mi się otworzyć pliku!");
        }

    }

    private static void writeToFile(String fileName, String docWithoutHTML) throws IOException {
        StringTokenizer strTok = new StringTokenizer(docWithoutHTML);

        while (strTok.hasMoreTokens()) {
            FileWriter writer = new FileWriter(fileName, true);
            String output = strTok.nextToken();

            if (output.length() > 3) {
                writer.append(output + " ");
                writer.close();
            }
        }
    }

    private static void isFileExist(String fileName) {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
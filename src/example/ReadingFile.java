package example;

import java.io.*;
import java.util.Scanner;

public class ReadingFile {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String fileName;
        BufferedReader br;
        String line;

        System.out.println("input nama file untuk dibaca: ");
        fileName = keyboard.nextLine();

        try {
            br = new BufferedReader(new FileReader(fileName));
//            line = s.readLine();
//
//            System.out.print("The first line in " + fileName + " is: ");
//            System.out.println(line);

            int row = 1;
            while ((line = br.readLine()) != null) {
                System.out.print("Line ke-" + row + " : ");
                System.out.println(line);
                row++;
            }

            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package example;

import java.io.*;
import java.util.Scanner;

public class WritingFile {
    public static void main(String[] args) {
        PrintWriter outputStream = null;
        Scanner keyboard = new Scanner(System.in);

        try {
            outputStream = new PrintWriter(new FileOutputStream("out.txt"));
        } catch(FileNotFoundException e) {
            System.out.println("Error opening the file out.txt. " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Enter three lines of text:");

        String line;
        int count;

        for (count = 1; count <= 3; count++) {
            line = keyboard.nextLine();
            outputStream.println(count + " " + line);
        }

        outputStream.close();
        System.out.println("... written to out.txt.");

       /* System.out.println("A for append or N for new file:");
        char ans = keyboard.next().charAt(0);
        boolean append = (ans == 'A' || ans == 'a');
        try {
            outputStream = new PrintWriter(new FileOutputStream("out.txt", append));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }*/
    }
}
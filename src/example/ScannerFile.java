package example;

import java.io.*;
import java.util.*;

public class ScannerFile {
    public static void main(String[] args) {
        int number;
        String word;

        try {
            Scanner inFile = new Scanner(new File("out.txt"));

            while (inFile.hasNext()) {
                number = inFile.nextInt();
                word = inFile.next();

                System.out.println(number + ":" + word);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

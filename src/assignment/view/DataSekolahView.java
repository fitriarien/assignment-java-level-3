package assignment.view;

import assignment.controller.FileController;
import assignment.model.DataPerKelas;

import java.io.*;
import java.util.*;

public class DataSekolahView {
    static String judul = "------------------------------\nAplikasi Pengolah Nilai Siswa\n------------------------------";
    static String exit = "0. Exit";
    static String menuBack = "1. Kembali ke menu utama";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int menu;
        int submenu;
        String dir = "C:\\temp\\direktori\\";
        String file = "data_sekolah.csv";
        ArrayList<DataPerKelas> dataPerKelasList = new ArrayList<>();
        ArrayList<Integer> semuaNilai = new ArrayList<>();
        String kelas;
        FileController fileController = new FileController();
        boolean hasReadFile = false;
        boolean hasGeneratedModusFile;
        boolean hasGeneratedMeanMedianFile;

        menuUtama:
        do {
            System.out.println(judul);
            System.out.println("Letakkan file csv dengan nama file data_sekolah di direktori berikut: C://temp//direktori");
            System.out.println();
            System.out.println("pilih menu:");
            System.out.println("1. Generate txt untuk menampilkan modus");
            System.out.println("2. Generate txt untuk menampilkan nilai rata-rata, median");
            System.out.println("3. Generate kedua file");
            System.out.println(exit);

            // input selected menu
            System.out.print("Input nomor menu = ");
            menu = input.nextInt();

            // read file
            if (menu != 0 && !hasReadFile) {
                try {
                    FileReader fr=new FileReader(dir+file);
                    BufferedReader br=new BufferedReader(fr);
                    String line;

                    while ((line = br.readLine()) != null) {
                        String[] metadata = line.split(";");
                        kelas = metadata[0];

                        ArrayList<Integer> nilaiList = new ArrayList<>();

                        for (int i = 1; i < metadata.length; i++) {
                            nilaiList.add(Integer.parseInt(metadata[i]));
                            semuaNilai.add(Integer.parseInt(metadata[i]));
                        }

                        dataPerKelasList.add(new DataPerKelas(kelas, new ArrayList<>(nilaiList)));
                    }

                    br.close();
                    fr.close();

                    hasReadFile = true;
                } catch (IOException e) {
                    do {
                        System.out.println(judul);
                        System.out.println("File tidak ditemukan\n");
                        System.out.println(exit);
                        System.out.println(menuBack);

                        System.out.print("Input nomor menu = ");
                        submenu = input.nextInt();

                        switch (submenu) {
                            case 0:
                                menu = 0;
                            case 1:
                                continue menuUtama;
                        }
                    } while (true);
                }
            }

            switch (menu) {
                case 1:
                    hasGeneratedModusFile = fileController.generateModusFile(semuaNilai, dataPerKelasList, dir);

                    if (hasGeneratedModusFile) {
                        do {
                            printAfterGenerating(true);

                            System.out.print("Input nomor menu = ");
                            submenu = input.nextInt();

                            switch (submenu) {
                                case 0:
                                    menu = 0;
                                case 1:
                                    continue menuUtama;
                            }
                        } while (true);
                    } else {
                        do {
                            printAfterGenerating(false);

                            System.out.print("Input nomor menu = ");
                            submenu = input.nextInt();

                            switch (submenu) {
                                case 0:
                                    menu = 0;
                                case 1:
                                    continue menuUtama;
                            }
                        } while (true);
                    }
                case 2:
                    hasGeneratedMeanMedianFile = fileController.generateMeanMedianFile(semuaNilai, dataPerKelasList, dir);

                    if (hasGeneratedMeanMedianFile) {
                        do {
                            printAfterGenerating(true);

                            System.out.print("Input nomor menu = ");
                            submenu = input.nextInt();

                            switch (submenu) {
                                case 0:
                                    menu = 0;
                                case 1:
                                    continue menuUtama;
                            }
                        } while (true);
                    } else {
                        do {
                            printAfterGenerating(false);

                            System.out.print("Input nomor menu = ");
                            submenu = input.nextInt();

                            switch (submenu) {
                                case 0:
                                    menu = 0;
                                case 1:
                                    continue menuUtama;
                            }
                        } while (true);
                    }
                case 3:
                    hasGeneratedModusFile = fileController.generateModusFile(semuaNilai, dataPerKelasList, dir);
                    hasGeneratedMeanMedianFile = fileController.generateMeanMedianFile(semuaNilai, dataPerKelasList, dir);

                    if (hasGeneratedModusFile && hasGeneratedMeanMedianFile) {
                        do {
                            printAfterGenerating(true);

                            System.out.print("Input nomor menu = ");
                            submenu = input.nextInt();

                            switch (submenu) {
                                case 0:
                                    menu = 0;
                                case 1:
                                    continue menuUtama;
                            }
                        } while (true);
                    } else {
                        do {
                            printAfterGenerating(false);

                            System.out.print("Input nomor menu = ");
                            submenu = input.nextInt();

                            switch (submenu) {
                                case 0:
                                    menu = 0;
                                case 1:
                                    continue menuUtama;
                            }
                        } while (true);
                    }

            }
        } while (menu != 0);

        input.close();
    }

    public static void printAfterGenerating(boolean isSuccess) {
        if (isSuccess) {
            System.out.println(judul);
            System.out.println("File telah di-generate di C://temp//direktori");
            System.out.println("silahkan cek\n");
            System.out.println(exit);
            System.out.println(menuBack);
        } else {
            System.out.println(judul);
            System.out.println("Gagal generate file\n");
            System.out.println(exit);
            System.out.println(menuBack);
        }
    }
}
package assignment.controller;

import assignment.model.DataPerKelas;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

public class FileController {
    public boolean generateModusFile(ArrayList<Integer> semuaNilai, ArrayList<DataPerKelas> dataPerKelasList, String dir) {
        String kelas;
        int modus;
        Map<Integer, Integer> frekNilai;
        DataSekolahController controller = new DataSekolahController();

        try {
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(dir + "data_sekolah_modus.txt"));
            outputStream.println("Berikut Hasil Pengolahan Nilai:\n");

            frekNilai = controller.hitungFrekNilai(semuaNilai);
            modus = controller.findModus(frekNilai);

            outputStream.println("SEMUA KELAS");
            outputStream.println("---------------------------------\n" + "Nilai\t\t| Frekuensi" + "\n---------------------------------");

            for (Map.Entry<Integer, Integer> entry : frekNilai.entrySet()) {
                if (entry.getKey() < 6) {
                    outputStream.println("kurang dari 6\t| " + entry.getValue());
                } else {
                    outputStream.println(entry.getKey() + "\t\t| " + entry.getValue());
                }
            }
            outputStream.println("Modus = " + modus + "\n");

            // list modus per kelas
            for (DataPerKelas data : dataPerKelasList) {
                kelas = data.getKelas();
                frekNilai = controller.hitungFrekNilai(data.getNilaiList());
                modus = controller.findModus(frekNilai);

                data.setModus(modus);

                outputStream.println("Kelas " + kelas.charAt(kelas.length() - 1));
                outputStream.println("---------------------------------\n" + "Nilai\t\t| Frekuensi" + "\n---------------------------------");

                for (Map.Entry<Integer, Integer> entry : frekNilai.entrySet()) {
                    if (entry.getKey() < 6) {
                        outputStream.println("kurang dari 6\t| " + entry.getValue());
                    } else {
                        outputStream.println(entry.getKey() + "\t\t| " + entry.getValue());
                    }
                }
                outputStream.println("Modus = " + modus + "\n");
            }

            outputStream.close();
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public boolean generateMeanMedianFile(ArrayList<Integer> semuaNilai, ArrayList<DataPerKelas> dataPerKelasList, String dir) {
        String kelas;
        int modus;
        Map<Integer, Integer> frekNilai;
        double mean;
        int median;
        DataSekolahController controller = new DataSekolahController();
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        String formattedMean = "";

        try {
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(dir + "data_sekolah_mean_median.txt"));
            outputStream.println("Berikut Hasil Pengolahan Nilai:\n");

            mean = controller.calculateMean(semuaNilai);
            median = controller.findMedian(semuaNilai);
            frekNilai = controller.hitungFrekNilai(semuaNilai);
            modus = controller.findModus(frekNilai);

            formattedMean = decimalFormat.format(mean);

            outputStream.println("Berikut hasil sebaran data nilai semua kelas");
            outputStream.println("Mean: " + formattedMean);
            outputStream.println("Median: " + median);
            outputStream.println("Modus: " + modus + "\n");

            // per kelas
            for (DataPerKelas data : dataPerKelasList) {
                kelas = data.getKelas();

                mean = controller.calculateMean(data.getNilaiList());
                formattedMean = decimalFormat.format(mean);
                data.setMean(mean);

                median = controller.findMedian(data.getNilaiList());
                data.setMedian(median);

                frekNilai = controller.hitungFrekNilai(data.getNilaiList());
                modus = controller.findModus(frekNilai);
                data.setModus(modus);

                outputStream.println("Berikut hasil sebaran data nilai kelas " + kelas.charAt(kelas.length() - 1));
                outputStream.println("Mean: " + formattedMean);
                outputStream.println("Median: " + data.getMedian());
                outputStream.println("Modus: " + data.getModus() + "\n");
            }

            outputStream.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}

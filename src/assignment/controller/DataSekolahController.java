package assignment.controller;

import java.util.*;

public class DataSekolahController {
    public Map<Integer, Integer> hitungFrekNilai(ArrayList<Integer> nilaiList) {
        Map<Integer, Integer> frekNilai = new HashMap<>();

        for (int nilai : nilaiList) {
            frekNilai.put(nilai, frekNilai.getOrDefault(nilai, 0) + 1);
        }

        return frekNilai;
    }

    public int findModus(Map<Integer, Integer> frekNilai) {
        int modus = 0;
        int frekMaksimal = 0;

        for (Map.Entry<Integer, Integer> entry : frekNilai.entrySet()) {
            if (entry.getValue() > frekMaksimal) {
                frekMaksimal = entry.getValue();
                modus = entry.getKey();
            }
        }

        return modus;
    }

    public double calculateMean(ArrayList<Integer> nilaiList) {
        double sum = 0;

        for (int nilai : nilaiList) {
            sum += nilai;
        }

        return sum/(nilaiList.size());
    }

    public int findMedian(ArrayList<Integer> nilaiList) {
        int banyakNilai = nilaiList.size();
        Collections.sort(nilaiList);

        if (banyakNilai % 2 != 0) {
            // untuk ganjil
            return nilaiList.get((banyakNilai)/2);
        } else {
            // untuk genap
            int mid1 = nilaiList.get((banyakNilai/2) - 1);
            int mid2 = nilaiList.get((banyakNilai/2));
            return (mid1 + mid2) / 2;
        }
    }
}

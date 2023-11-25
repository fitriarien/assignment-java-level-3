package assignment.model;

import java.util.*;

public class DataPerKelas {
    private String kelas;
    private ArrayList<Integer> nilaiList;
    private int modus;
    private double mean;
    private int median;

    public DataPerKelas(String kelas, ArrayList<Integer> nilaiList) {
        this.kelas = kelas;
        this.nilaiList = nilaiList;
    }

    public DataPerKelas(String kelas, ArrayList<Integer> nilaiList, int modus, double mean, int median) {
        this.kelas = kelas;
        this.nilaiList = nilaiList;
        this.modus = modus;
        this.mean = mean;
        this.median = median;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public ArrayList<Integer> getNilaiList() {
        return nilaiList;
    }

    public void setNilaiList(ArrayList<Integer> nilaiList) {
        this.nilaiList = nilaiList;
    }

    public int getModus() {
        return modus;
    }

    public void setModus(int modus) {
        this.modus = modus;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public int getMedian() {
        return median;
    }

    public void setMedian(int median) {
        this.median = median;
    }


}

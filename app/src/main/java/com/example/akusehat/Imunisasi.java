package com.example.akusehat;

import android.os.Parcel;
import android.os.Parcelable;

public class Imunisasi implements Parcelable {
    private String namaAnak;
    private int umur;
    private int hariLahir;
    private int bulanLahir;
    private int tahunLahir;
    private int hariVaksin;
    private int bulanVaksin;
    private int tahunVaksin;
    private String jenisVaksin;
    private int vaksinKe;

    public Imunisasi() {}

    protected Imunisasi(Parcel in) {
        namaAnak = in.readString();
        umur = in.readInt();
    }

    public Imunisasi(String namaAnak, int umur, int hariLahir, int bulanLahir, int tahunLahir,
                     int hariVaksin, int bulanVaksin, int tahunVaksin, String jenisVaksin, int vaksinKe) {
        this.namaAnak = namaAnak;
        this.umur = umur;
        this.hariLahir = hariLahir;
        this.bulanLahir = bulanLahir;
        this.tahunLahir = tahunLahir;
        this.hariVaksin = hariVaksin;
        this.bulanVaksin = bulanVaksin;
        this.tahunVaksin = tahunVaksin;
        this.jenisVaksin = jenisVaksin;
        this.vaksinKe = vaksinKe;
    }

    public String getNamaAnak() {
        return namaAnak;
    }

    public void setNamaAnak(String namaAnak) {
        this.namaAnak = namaAnak;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public int getHariLahir() {
        return hariLahir;
    }

    public void setHariLahir(int hariLahir) {
        this.hariLahir = hariLahir;
    }

    public int getHariVaksin() {
        return hariVaksin;
    }

    public void setHariVaksin(int hariVaksin) {
        this.hariVaksin = hariVaksin;
    }

    public String getJenisVaksin() {
        return jenisVaksin;
    }

    public void setJenisVaksin(String jenisVaksin) {
        this.jenisVaksin = jenisVaksin;
    }

    public int getVaksinKe() {
        return vaksinKe;
    }

    public void setVaksinKe(int vaksinKe) {
        this.vaksinKe = vaksinKe;
    }

    public int getBulanLahir() {
        return bulanLahir;
    }

    public void setBulanLahir(int bulanLahir) {
        this.bulanLahir = bulanLahir;
    }

    public int getTahunLahir() {
        return tahunLahir;
    }

    public void setTahunLahir(int tahunLahir) {
        this.tahunLahir = tahunLahir;
    }

    public int getBulanVaksin() {
        return bulanVaksin;
    }

    public void setBulanVaksin(int bulanVaksin) {
        this.bulanVaksin = bulanVaksin;
    }

    public int getTahunVaksin() {
        return tahunVaksin;
    }

    public void setTahunVaksin(int tahunVaksin) {
        this.tahunVaksin = tahunVaksin;
    }

    public static final Creator<Imunisasi> CREATOR = new Creator<Imunisasi>() {
        @Override
        public Imunisasi createFromParcel(Parcel in) {
            return new Imunisasi(in);
        }

        @Override
        public Imunisasi[] newArray(int size) {
            return new Imunisasi[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.namaAnak);
        parcel.writeInt(this.umur);
        parcel.writeInt(this.hariLahir);
        parcel.writeInt(this.bulanLahir);
        parcel.writeInt(this.tahunLahir);
        parcel.writeInt(this.hariVaksin);
        parcel.writeInt(this.bulanVaksin);
        parcel.writeInt(this.tahunVaksin);
        parcel.writeString(this.jenisVaksin);
        parcel.writeInt(this.vaksinKe);
    }
}

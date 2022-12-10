package com.example.akusehat;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDate;

public class Imunisasi implements Parcelable {
    private String namaAnak;
    private int umur;
    private LocalDate tanggalLahir;
    private LocalDate tanggalVaksin;
    private String jenisVaksin;
    private int vaksinKe;

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

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public LocalDate getTanggalVaksin() {
        return tanggalVaksin;
    }

    public void setTanggalVaksin(LocalDate tanggalVaksin) {
        this.tanggalVaksin = tanggalVaksin;
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

    protected Imunisasi(Parcel in) {
        namaAnak = in.readString();
        umur = in.readInt();
    }

    public Imunisasi(String namaAnak, int umur, LocalDate tanggalLahir, LocalDate tanggalVaksin,
                     String jenisVaksin, int vaksinKe) {
        this.namaAnak = namaAnak;
        this.umur = umur;
        this.tanggalLahir = tanggalLahir;
        this.tanggalVaksin = tanggalVaksin;
        this.jenisVaksin = jenisVaksin;
        this.vaksinKe = vaksinKe;
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
    }
}

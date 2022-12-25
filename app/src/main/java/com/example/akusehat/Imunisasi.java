package com.example.akusehat;

import android.os.Parcel;
import android.os.Parcelable;

public class Imunisasi implements Parcelable {
    private String uuid;
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
    private String idGambar;

    public String getIdGambar() {
        return idGambar;
    }

    public void setIdGambar(String idGambar) {
        this.idGambar = idGambar;
    }

    public Imunisasi() {}

    protected Imunisasi(Parcel in) {
        uuid = in.readString();
        namaAnak = in.readString();
        umur = in.readInt();
        hariLahir = in.readInt();
        bulanLahir = in.readInt();
        tahunLahir = in.readInt();
        hariVaksin = in.readInt();
        bulanVaksin = in.readInt();
        tahunVaksin = in.readInt();
        jenisVaksin = in.readString();
        vaksinKe = in.readInt();
        idGambar = in.readString();
    }

    public Imunisasi(String namaAnak, int umur, int hariLahir, int bulanLahir, int tahunLahir,
                     int hariVaksin, int bulanVaksin, int tahunVaksin, String jenisVaksin, int vaksinKe, String idGambar) {
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
        this.idGambar = idGambar;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
        parcel.writeString(this.uuid);
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
        parcel.writeString(this.idGambar);
    }
}

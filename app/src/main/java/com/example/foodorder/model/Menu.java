package com.example.foodorder.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
    private String nama;
    private Float harga;
    private String url;

    protected Menu(Parcel in) {
        nama = in.readString();
        if (in.readByte() == 0) {
            harga = null;
        } else {
            harga = in.readFloat();
        }
        url = in.readString();
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Float getHarga() {
        return harga;
    }

    public void setHarga(Float harga) {
        this.harga = harga;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        if (harga == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeFloat(harga);
        }
        parcel.writeString(url);
    }
}

package com.example.asetpribadi.object;

import android.os.Parcel;
import android.os.Parcelable;

public class AsetPribadi implements Parcelable {

    private String merk;
    private int intGambar;

    public AsetPribadi(String merk, int intGambar) {
        this.merk = merk;
        this.intGambar = intGambar;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getIntGambar() {
        return intGambar;
    }

    public void setIntGambar(int intGambar) {
        this.intGambar = intGambar;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.merk);
        dest.writeInt(this.intGambar);
    }

    protected AsetPribadi(Parcel in) {
        this.merk = in.readString();
        this.intGambar = in.readInt();
    }

    public static final Creator<AsetPribadi> CREATOR = new Creator<AsetPribadi>() {
        @Override
        public AsetPribadi createFromParcel(Parcel source) {
            return new AsetPribadi(source);
        }

        @Override
        public AsetPribadi[] newArray(int size) {
            return new AsetPribadi[size];
        }
    };
}

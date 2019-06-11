package com.mauldev.astropedia.models;

import android.os.Parcel;
import android.os.Parcelable;

public class StarModel implements Parcelable {
    private String name;
    private String luminosity;
    private String shortDescription;

    public StarModel() {
        this.name = "";
        this.luminosity = "";
        this.shortDescription = "";
    }

    public StarModel(String name, String luminosity, String shortDescription, int yearDiscovered, float solarLuminosity) {
        this.name = name;
        this.luminosity = luminosity;
        this.shortDescription = shortDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(String luminosity) {
        this.luminosity = luminosity;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.luminosity);
        dest.writeString(this.shortDescription);
    }

    protected StarModel(Parcel in) {
        this.name = in.readString();
        this.luminosity = in.readString();
        this.shortDescription = in.readString();
    }

    public static final Parcelable.Creator<StarModel> CREATOR = new Parcelable.Creator<StarModel>() {
        @Override
        public StarModel createFromParcel(Parcel source) {
            return new StarModel(source);
        }

        @Override
        public StarModel[] newArray(int size) {
            return new StarModel[size];
        }
    };
}

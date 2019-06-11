package com.mauldev.astropedia.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ConstellationModel implements Parcelable {

    private String name;
    private int totalStar;
    private StarModel brightestStar;
    private String bestViewMonthorSeason;
    private String shortDescription;
    private String illustrationImageUrl;
    private String observationImageUrl;
    private String wikipediaUrl;
    private boolean isVisibleWithNakedEye;

    public ConstellationModel() {
        this.name = "";
        this.totalStar = 0;
        this.brightestStar = new StarModel();
        this.bestViewMonthorSeason = "";
        this.shortDescription = "";
        this.illustrationImageUrl = "";
        this.observationImageUrl = "";
        this.wikipediaUrl = "";
        this.isVisibleWithNakedEye = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalStar() {
        return totalStar;
    }

    public void setTotalStar(int totalStar) {
        this.totalStar = totalStar;
    }

    public StarModel getBrightestStar() {
        return brightestStar;
    }

    public void setBrightestStar(StarModel brightestStar) {
        this.brightestStar = brightestStar;
    }

    public String getBestViewMonthorSeason() {
        return bestViewMonthorSeason;
    }

    public void setBestViewMonthorSeason(String bestViewMonthorSeason) {
        this.bestViewMonthorSeason = bestViewMonthorSeason;
    }

    public String getIllustrationImageUrl() {
        return illustrationImageUrl;
    }

    public void setIllustrationImageUrl(String illustrationImageUrl) {
        this.illustrationImageUrl = illustrationImageUrl;
    }

    public String getObservationImageUrl() {
        return observationImageUrl;
    }

    public void setObservationImageUrl(String observationImageUrl) {
        this.observationImageUrl = observationImageUrl;
    }

    public String getWikipediaUrl() {
        return wikipediaUrl;
    }

    public void setWikipediaUrl(String wikipediaUrl) {
        this.wikipediaUrl = wikipediaUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public boolean isVisibleWithNakedEye() {
        return isVisibleWithNakedEye;
    }

    public void setVisibleWithNakedEye(boolean visibleWithNakedEye) {
        isVisibleWithNakedEye = visibleWithNakedEye;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.totalStar);
        dest.writeParcelable(this.brightestStar, flags);
        dest.writeString(this.bestViewMonthorSeason);
        dest.writeString(this.shortDescription);
        dest.writeString(this.illustrationImageUrl);
        dest.writeString(this.observationImageUrl);
        dest.writeString(this.wikipediaUrl);
        dest.writeByte(this.isVisibleWithNakedEye ? (byte) 1 : (byte) 0);
    }

    protected ConstellationModel(Parcel in) {
        this.name = in.readString();
        this.totalStar = in.readInt();
        this.brightestStar = in.readParcelable(StarModel.class.getClassLoader());
        this.bestViewMonthorSeason = in.readString();
        this.shortDescription = in.readString();
        this.illustrationImageUrl = in.readString();
        this.observationImageUrl = in.readString();
        this.wikipediaUrl = in.readString();
        this.isVisibleWithNakedEye = in.readByte() != 0;
    }

    public static final Parcelable.Creator<ConstellationModel> CREATOR = new Parcelable.Creator<ConstellationModel>() {
        @Override
        public ConstellationModel createFromParcel(Parcel source) {
            return new ConstellationModel(source);
        }

        @Override
        public ConstellationModel[] newArray(int size) {
            return new ConstellationModel[size];
        }
    };
}

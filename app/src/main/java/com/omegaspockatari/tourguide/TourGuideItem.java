package com.omegaspockatari.tourguide;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Miranda on 8/3/2016.
 */
public class TourGuideItem implements Parcelable {
    public static final Creator<TourGuideItem> CREATOR = new Creator<TourGuideItem>() {
        @Override
        public TourGuideItem createFromParcel(Parcel in) {
            return new TourGuideItem(in);
        }

        @Override
        public TourGuideItem[] newArray(int size) {
            return new TourGuideItem[size];
        }
    };
    private static final int NO_IMAGE_PROVIDED = -1;
    // Website of Location
    private String mLocationWebsite;
    // Address of Location
    private String mLocationAddress;
    // Telephone of Location
    private String mLocationTelephone;
    // Name of Location
    private String mLocationName;
    // Blurb of Location
    private String mLocationBlurb;
    // Image resource ID
    private int mLocationImageResourceId = NO_IMAGE_PROVIDED;

    public TourGuideItem(String mLocationWebsite, String mLocationAddress, String mLocationTelephone,
                         String mLocationName, String mLocationBlurb, int mLocationImageResourceId) {
        this.mLocationWebsite = mLocationWebsite;
        this.mLocationAddress = mLocationAddress;
        this.mLocationTelephone = mLocationTelephone;
        this.mLocationName = mLocationName;
        this.mLocationBlurb = mLocationBlurb;
        this.mLocationImageResourceId = mLocationImageResourceId;
    }

    public TourGuideItem() {
    }

    protected TourGuideItem(Parcel in) {
        mLocationWebsite = in.readString();
        mLocationAddress = in.readString();
        mLocationTelephone = in.readString();
        mLocationName = in.readString();
        mLocationImageResourceId = in.readInt();
    }

    public String getmLocationWebsite() {
        return mLocationWebsite;
    }

    public void setmLocationWebsite(String mLocationWebsite) {
        this.mLocationWebsite = mLocationWebsite;
    }

    public String getmLocationAddress() {
        return mLocationAddress;
    }

    public void setmLocationAddress(String mLocationAddress) {
        this.mLocationAddress = mLocationAddress;
    }

    public String getmLocationTelephone() {
        return mLocationTelephone;
    }

    public void setmLocationTelephone(String mLocationTelephone) {
        this.mLocationTelephone = mLocationTelephone;
    }

    public String getmLocationName() {
        return mLocationName;
    }

    public void setmLocationName(String mLocationName) {
        this.mLocationName = mLocationName;
    }

    public int getmLocationImageResourceId() {
        return mLocationImageResourceId;
    }

    public void setmLocationImageResourceId(int mLocationImageResourceId) {
        this.mLocationImageResourceId = mLocationImageResourceId;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mLocationImageResourceId);
        dest.writeString(mLocationAddress);
        dest.writeString(mLocationName);
        dest.writeString(mLocationTelephone);
        dest.writeString(mLocationWebsite);
    }
}

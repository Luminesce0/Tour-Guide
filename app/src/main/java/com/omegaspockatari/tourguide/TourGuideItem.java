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
    private static final int NO_RESOURCE_PROVIDED = -1;
    // Website of Location
    private int mLocationWebsite = NO_RESOURCE_PROVIDED;
    // Address of Location
    private int mLocationAddress = NO_RESOURCE_PROVIDED;
    // Telephone of Location
    private int mLocationTelephone = NO_RESOURCE_PROVIDED;
    // Name of Location
    private int mLocationName = NO_RESOURCE_PROVIDED;
    // Blurb of Location
    private int mLocationBlurb = NO_RESOURCE_PROVIDED;
    // Image resource ID
    private int mLocationImageResourceId = NO_RESOURCE_PROVIDED;

    public TourGuideItem(int mLocationWebsite, int mLocationAddress, int mLocationTelephone,
                         int mLocationName, int mLocationBlurb, int mLocationImageResourceId) {
        this.mLocationWebsite = mLocationWebsite;
        this.mLocationAddress = mLocationAddress;
        this.mLocationTelephone = mLocationTelephone;
        this.mLocationName = mLocationName;
        this.mLocationBlurb = mLocationBlurb;
        this.mLocationImageResourceId = mLocationImageResourceId;
    }

    public TourGuideItem(int mLocationWebsite, int mLocationAddress, int mLocationName,
                         int mLocationBlurb, int mLocationImageResourceId) {
        this.mLocationWebsite = mLocationWebsite;
        this.mLocationAddress = mLocationAddress;
        this.mLocationName = mLocationName;
        this.mLocationBlurb = mLocationBlurb;
        this.mLocationImageResourceId = mLocationImageResourceId;
    }

    public TourGuideItem() {
    }

    private TourGuideItem(Parcel in) {
        mLocationWebsite = in.readInt();
        mLocationAddress = in.readInt();
        mLocationTelephone = in.readInt();
        mLocationName = in.readInt();
        mLocationBlurb = in.readInt();
        mLocationImageResourceId = in.readInt();
    }

    public int getmLocationWebsite() {
        return mLocationWebsite;
    }

    public int getmLocationAddress() {
        return mLocationAddress;
    }

    public int getmLocationTelephone() {
        return mLocationTelephone;
    }

    public int getmLocationName() {
        return mLocationName;
    }

    public int getmLocationBlurb() {
        return mLocationBlurb;
    }

    public int getmLocationImageResourceId() {
        return mLocationImageResourceId;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mLocationImageResourceId);
        dest.writeInt(mLocationAddress);
        dest.writeInt(mLocationName);
        dest.writeInt(mLocationTelephone);
        dest.writeInt(mLocationWebsite);
        dest.writeInt(mLocationBlurb);
    }

    public boolean hasPhoneNumber() {
        return mLocationTelephone != NO_RESOURCE_PROVIDED;
    }
}

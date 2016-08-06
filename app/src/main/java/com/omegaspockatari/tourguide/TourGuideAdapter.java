package com.omegaspockatari.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Miranda on 8/3/2016.
 */
public class TourGuideAdapter extends ArrayAdapter<TourGuideItem> {

    public TourGuideAdapter(Context context, ArrayList<TourGuideItem> tourGuideItems) {
        super(context, 0, tourGuideItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        TourGuideItem tourGuideItem = getItem(position);

        TextView tourGuideLocationName = (TextView) listItemView.findViewById(R.id.location_name);
        tourGuideLocationName.setText(tourGuideItem.getmLocationName());

        ImageView tourGuideLocationImage = (ImageView) listItemView.findViewById(R.id.location_image);
        tourGuideLocationImage.setBackgroundResource(tourGuideItem.getmLocationImageResourceId());

        return listItemView;
    }

}

package com.omegaspockatari.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Kiora on 8/5/2016.
 */
public class HotelsFragment extends Fragment {
    public HotelsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tour_guide_list, container, false);

        final ArrayList<TourGuideItem> tourGuideItems = new ArrayList<>();

        tourGuideItems.add(new TourGuideItem(R.string.hotel_website_1, R.string.hotel_address_1,
                R.string.hotel_number_1, R.string.hotel_name_1, R.string.hotel_blurb_1,
                R.drawable.hotel_picture_1));
        tourGuideItems.add(new TourGuideItem(R.string.hotel_website_2, R.string.hotel_address_2,
                R.string.hotel_number_2, R.string.hotel_name_2, R.string.hotel_blurb_2,
                R.drawable.hotel_picture_2));
        tourGuideItems.add(new TourGuideItem(R.string.hotel_website_3, R.string.hotel_address_3,
                R.string.hotel_number_3, R.string.hotel_name_3, R.string.hotel_blurb_3,
                R.drawable.hotel_picture_3));
        tourGuideItems.add(new TourGuideItem(R.string.hotel_website_4, R.string.hotel_address_4,
                R.string.hotel_number_4, R.string.hotel_name_4, R.string.hotel_blurb_4,
                R.drawable.hotel_picture_4));
        tourGuideItems.add(new TourGuideItem(R.string.hotel_website_5, R.string.hotel_address_5,
                R.string.hotel_number_5, R.string.hotel_name_5, R.string.hotel_blurb_5,
                R.drawable.hotel_picture_5));

        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(), tourGuideItems);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), TourGuidePage.class);

                intent.putParcelableArrayListExtra("tourGuideItem", tourGuideItems);

                startActivity(intent);
            }
        });


        return rootView;
    }

}

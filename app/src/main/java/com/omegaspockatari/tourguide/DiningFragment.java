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
 * Created by Kiora on 8/6/2016.
 */
public class DiningFragment extends Fragment {
    public DiningFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_guide_list, container, false);

        final ArrayList<TourGuideItem> tourGuideItems = new ArrayList<>();

        tourGuideItems.add(new TourGuideItem(R.string.dining_website_1, R.string.dining_address_1,
                R.string.dining_number_1, R.string.dining_name_1, R.string.dining_blurb_1,
                R.drawable.dining_picture_1));
        tourGuideItems.add(new TourGuideItem(R.string.dining_website_2, R.string.dining_address_2,
                R.string.dining_number_2, R.string.dining_name_2, R.string.dining_blurb_2,
                R.drawable.dining_picture_2));
        tourGuideItems.add(new TourGuideItem(R.string.dining_website_3, R.string.dining_address_3,
                R.string.dining_number_3, R.string.dining_name_3, R.string.dining_blurb_3,
                R.drawable.dining_picture_3));
        tourGuideItems.add(new TourGuideItem(R.string.dining_website_4, R.string.dining_address_4,
                R.string.dining_number_4, R.string.dining_name_4, R.string.dining_blurb_4,
                R.drawable.dining_picture_4));
        tourGuideItems.add(new TourGuideItem(R.string.dining_website_5, R.string.dining_address_5,
                R.string.dining_number_5, R.string.dining_name_5, R.string.dining_blurb_5,
                R.drawable.dining_picture_5));

        TourGuideAdapter adapter = new TourGuideAdapter(getContext(), tourGuideItems);

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

        return listView;
    }
}

package com.omegaspockatari.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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

        final ArrayList<TourGuideItem> tourGuideItems = new ArrayList<TourGuideItem>();

        tourGuideItems.add(new TourGuideItem(R.string.hotel_website_1, R.string.hotel_address_1,
                R.string.hotel_number_1, R.string.hotel_name_1, R.string.hotel_blurb_1, R.drawable.hotel_picture_1));

        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(), tourGuideItems);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //We'll create a new view here dog.
                TourGuideItem item = tourGuideItems.get(position);

                String strings = item.getmLocationAddress();
                String string2 = "Here's a string that fucking works shit";
                Log.v("Burp", string2);



                Intent intent = new Intent(getActivity(), TourGuidePageAdapter.class);
                intent.putExtra("Stuff", tourGuideItems);
                // Create a new intent to open the (@link NowPlayingActivity)
                startActivity(intent);
            }
        });


        return rootView;
    }

}

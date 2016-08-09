package com.omegaspockatari.tourguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kiora on 8/5/2016.
 */
public class TourGuidePage extends AppCompatActivity {

    public TourGuidePage() {
    }

    /*
     * To save some memory I've heard that accessing the fields directly instead of
     * using getters is more effecient in android. Must study up on this.
     * How is it done?
     */

    private void GenerateTourGuidePage(TourGuideItem tourGuideItem) {

        int mLocationAddress = tourGuideItem.getmLocationAddress();
        int mLocationImageResourceId = tourGuideItem.getmLocationImageResourceId();
        int mLocationName = tourGuideItem.getmLocationName();
        int mLocationTelephone = tourGuideItem.getmLocationTelephone();
        int mLocationWebsite = tourGuideItem.getmLocationWebsite();
        int mLocationBlurb = tourGuideItem.getmLocationBlurb();

        // Location Image
        ImageView locationImage = (ImageView) findViewById(R.id.location_image);
        locationImage.setBackgroundResource(mLocationImageResourceId);

        // Location Name
        TextView locationNameTextView = (TextView) findViewById(R.id.location_page_name);
        locationNameTextView.setText(mLocationName);


        // Location Phone Number
        TextView locationPhoneNumber = (TextView) findViewById(R.id.location_page_phone_number);
        locationPhoneNumber.setText(mLocationTelephone);

        if (tourGuideItem.hasPhoneNumber()) {
            locationPhoneNumber.setText(tourGuideItem.getmLocationTelephone());

            locationPhoneNumber.setVisibility(View.VISIBLE);
        } else {
            locationPhoneNumber.setVisibility(View.GONE);
        }

        // Location Directions
        TextView locationDirections = (TextView) findViewById(R.id.location_page_direction);
        locationDirections.setText(mLocationAddress);

        // Location Website
        TextView locationWebsite = (TextView) findViewById(R.id.location_page_website);
        locationWebsite.setText(mLocationWebsite);

        if (tourGuideItem.hasPhoneNumber()) {
            locationWebsite.setText(tourGuideItem.getmLocationWebsite());

            locationWebsite.setVisibility(View.VISIBLE);
        } else {
            locationWebsite.setVisibility(View.GONE);
        }


        // Location Blurb
        TextView locationBlurb = (TextView) findViewById(R.id.location_page_blurb);
        locationBlurb.setText(mLocationBlurb);


        // Location Phone Number Text
        TextView locationPhoneNumberText = (TextView) findViewById(R.id.location_page_phone_number_text);
        locationPhoneNumberText.setText(mLocationTelephone);
        locationPhoneNumberText.setMovementMethod(LinkMovementMethod.getInstance());
        stripUnderlines(locationPhoneNumberText);

        // Location Directions Text
        TextView locationDirectionsText = (TextView) findViewById(R.id.location_page_direction_text);
        locationDirectionsText.setText(mLocationAddress);
        locationDirectionsText.setMovementMethod(LinkMovementMethod.getInstance());
        stripUnderlines(locationDirectionsText);

        // Location Website Text
        TextView locationWebsiteText = (TextView) findViewById(R.id.location_page_website);
        locationWebsiteText.setText(mLocationWebsite);
        locationWebsiteText.setMovementMethod(LinkMovementMethod.getInstance());
        stripUnderlines(locationWebsiteText);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_guide_list_selection);
        TourGuideItem tourGuideItem = getIntent().getParcelableExtra("tourGuideItem");

        GenerateTourGuidePage(tourGuideItem);
    }

    private void stripUnderlines(TextView textView) {
        Spannable s = new SpannableString(textView.getText());
        URLSpan[] spans = s.getSpans(0, s.length(), URLSpan.class);
        for (URLSpan span : spans) {
            int start = s.getSpanStart(span);
            int end = s.getSpanEnd(span);
            s.removeSpan(span);
            span = new URLSpanNoUnderline(span.getURL());
            s.setSpan(span, start, end, 0);
        }
        textView.setText(s);
    }

    // Get rid of underlines.
    // Reference: https://stackoverflow.com/questions/4096851/remove-underline-from-links-in-textview-android/4463535#4463535
    private class URLSpanNoUnderline extends URLSpan {
        public URLSpanNoUnderline(String url) {
            super(url);
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }
    }
}
package com.pakbachelors.crona.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pakbachelors.crona.R;
import com.pakbachelors.crona.model.Staticts;

public class StatusDetailActivity extends AppCompatActivity {


    //views
    private Staticts current;
    private ImageView crossIm;
    private TextView name, locationId, continentName, countryName, provinceName, currentConfirmedCount, confirmedCount, suspectedCount, curedCount, deadCount, updateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_detail);

        current = (Staticts) getIntent().getSerializableExtra("data");

        //Views initialtion
        crossIm = findViewById(R.id.cross_im);
        name = findViewById(R.id.name_tv);
        locationId = findViewById(R.id.location_id);
        continentName = findViewById(R.id.continent_tv);
        countryName = findViewById(R.id.country_tv);
        provinceName = findViewById(R.id.province_tv);
        currentConfirmedCount = findViewById(R.id.current_confirmed_count_tv);
        confirmedCount = findViewById(R.id.confirmed_count_tv);
        suspectedCount = findViewById(R.id.suspected_count_tv);
        curedCount = findViewById(R.id.cured_count_tv);
        deadCount = findViewById(R.id.dead_count_tv);
        updateTime = findViewById(R.id.update_time_tv);

        locationId.setText(current.getLocationId() + "");
        name.setText(current.getCountryEnglishName());
        continentName.setText(current.getContinentEnglishName());
        countryName.setText(current.getCountryEnglishName());
        provinceName.setText(current.getProvinceEnglishName());
        currentConfirmedCount.setText(current.getConfirmedCount() + "");
        confirmedCount.setText(current.getConfirmedCount() + "");
        suspectedCount.setText(current.getSuspectedCount() + "");
        curedCount.setText(current.getCuredCount() + "");
        deadCount.setText(current.getDeadCount() + "");
        updateTime.setText("N/A");

        crossIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}

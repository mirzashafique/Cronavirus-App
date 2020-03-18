package com.pakbachelors.crona.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.pakbachelors.crona.R;
import com.pakbachelors.crona.T;
import com.pakbachelors.crona.adapter.SectionsPagerAdapter;
import com.pakbachelors.crona.model.Checker;

import java.util.ArrayList;

public class CheckerActivity extends AppCompatActivity {

    //veriables
    private int currentIndex;
    private ArrayList<Checker> data;

    //Views
    private TextView currentTxt;
    private Button backBtn, nextBtn;
    private ImageView crossBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checker);

        //veriables
        data = new ArrayList<>();
        data.add(new Checker(getString(R.string.ferver), getString(R.string.is_you_feeling), false, false, 80));
        data.add(new Checker(getString(R.string.raini_nose), getString(R.string.is_you_feeling), false, false, 80));
        data.add(new Checker(getString(R.string.dry_cough), getString(R.string.is_you_feeling), false, false, 70));
        data.add(new Checker(getString(R.string.short_breath), getString(R.string.is_you_feeling), false, false, 60));
        data.add(new Checker(getString(R.string.sore_throat), getString(R.string.is_you_feeling), false, false, 50));
        data.add(new Checker(getString(R.string.fatigue), getString(R.string.is_you_feeling), false, false, 38));
        data.add(new Checker(getString(R.string.headache), getString(R.string.is_you_feeling), false, false, 13));
        data.add(new Checker(getString(R.string.chill), getString(R.string.is_you_feeling), false, false, 11));
        data.add(new Checker(getString(R.string.nausea_vomiting), getString(R.string.is_you_feeling), false, false, 5));
        data.add(new Checker(getString(R.string.diarrhoea), getString(R.string.is_you_feeling), false, false, 3));
        data.add(new Checker(getString(R.string.muscle_pain), getString(R.string.is_you_feeling), false, false, 14));


        currentIndex = 0;
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), data);
        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        //Views
        crossBtn = findViewById(R.id.cross_im);
        currentTxt = findViewById(R.id.current_tv);
        backBtn = findViewById(R.id.back_btn);
        nextBtn = findViewById(R.id.next_btn);


        int temp = currentIndex + 1;
        currentTxt.setText("(" + temp + "/" + data.size() + ")");

        //listners
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex > 0) {
                    currentIndex--;
                    viewPager.setCurrentItem(currentIndex);
                    int temp = currentIndex + 1;
                    currentTxt.setText("(" + temp + "/" + data.size() + ")");

                    if (currentIndex < data.size() - 1) {
                        nextBtn.setText(getString(R.string.next));
                    }
                } else {

                }

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentIndex < data.size() - 1) {
                    if (data.get(currentIndex).isChecked()) {
                        currentIndex++;
                        viewPager.setCurrentItem(currentIndex);
                        int temp = currentIndex + 1;
                        currentTxt.setText("(" + temp + "/" + data.size() + ")");
                        if (currentIndex == data.size() - 1) {
                            nextBtn.setText(R.string.finish);
                        }
                    } else {
                        T.message(getApplicationContext(), "Please mark the status.");
                    }

                } else {
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("data", data);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                }
            }
        });

        crossBtn.setOnClickListener(new View.OnClickListener() {
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

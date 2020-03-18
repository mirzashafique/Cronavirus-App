package com.pakbachelors.crona.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pakbachelors.crona.R;
import com.pakbachelors.crona.model.Checker;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    //Veriables
    int totolCount;
    boolean isSerious;
    private ArrayList<Checker> data;

    //Views
    private ImageView crossBtn;
    private TextView resultsTxt, comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        //veriables
        totolCount = 0;
        isSerious = false;
        data = (ArrayList<Checker>) getIntent().getSerializableExtra("data");

        //views
        crossBtn=findViewById(R.id.cross_im);
        resultsTxt = findViewById(R.id.resutls_tv);
        comments = findViewById(R.id.comment_tv);
        String results = "";
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).isAvailable()) {
                if (i < 5) {
                    isSerious = true;
                }
                results = results + "•   " + data.get(i).getDisease() + "\n";
                resultsTxt.setText(results);
                totolCount = totolCount + data.get(i).getPercentage();
            }

            if (i == data.size() - 1) {
                if (totolCount > 220) {
                    //very bad
                    comments.setText(R.string.result_1);
                } else if (totolCount < 220 && totolCount > 20) {
                    //Medium
                    if (isSerious) {
                        comments.setText(R.string.result_2);
                    } else {
                        comments.setText(R.string.result_3);
                    }
                } else {
                    comments.setText(R.string.result_4);
                }
            }
        }

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

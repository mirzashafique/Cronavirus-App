package com.pakbachelors.crona;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.pakbachelors.crona.activity.CheckerActivity;
import com.pakbachelors.crona.activity.StatusActivity;
import com.pakbachelors.crona.activity.TextActivity;
import com.pakbachelors.crona.model.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Veriables
    private ArrayList<Text> symptomsData, infectedData, precautionsData, historyData;
    //Views
    private CardView statusBtn, checkerBtn, symptomsBtn, infectedBtn, precautionsBtn, historyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Veriables
        symptomsData = new ArrayList<>();
        infectedData = new ArrayList<>();
        precautionsData = new ArrayList<>();
        historyData = new ArrayList<>();

        //Symptoms
        symptomsData.add(new Text(1, getString(R.string.symptoms_recong), "", ""));
        symptomsData.add(new Text(5, "", "", ""));
        symptomsData.add(new Text(2, "", getString(R.string.day_1), ""));
        symptomsData.add(new Text(3, "", "", getString(R.string.symptoms_similar)));
        symptomsData.add(new Text(3, "", "", getString(R.string.mild_throat)));
        symptomsData.add(new Text(3, "", "", getString(R.string.not_fever)));
        symptomsData.add(new Text(5, "", "", ""));
        symptomsData.add(new Text(2, "", getString(R.string.day_4), ""));
        symptomsData.add(new Text(3, "", "", getString(R.string.throat_little)));
        symptomsData.add(new Text(3, "", "", getString(R.string.voice_becoming)));
        symptomsData.add(new Text(3, "", "", getString(R.string.body_temp)));
        symptomsData.add(new Text(3, "", "", getString(R.string.beginning_of_dist)));
        symptomsData.add(new Text(3, "", "", getString(R.string.mild_headaches)));
        symptomsData.add(new Text(3, "", "", getString(R.string.mild_diarrhoea)));
        symptomsData.add(new Text(5, "", "", ""));
        symptomsData.add(new Text(2, "", getString(R.string.day_5), ""));
        symptomsData.add(new Text(3, "", "", getString(R.string.throat_pain_and)));
        symptomsData.add(new Text(3, "", "", getString(R.string.mild_body_temp)));
        symptomsData.add(new Text(3, "", "", getString(R.string.weak_body_and)));
        symptomsData.add(new Text(5, "", "", ""));
        symptomsData.add(new Text(2, "", getString(R.string.day_6), ""));
        symptomsData.add(new Text(3, "", "", getString(R.string.beginning_of_mild)));
        symptomsData.add(new Text(3, "", "", getString(R.string.dry_cough_1)));
        symptomsData.add(new Text(3, "", "", getString(R.string.throat_pain_while)));
        symptomsData.add(new Text(3, "", "", getString(R.string.exhausted_and_nausea)));
        symptomsData.add(new Text(3, "", "", getString(R.string.difficulty_in)));
        symptomsData.add(new Text(3, "", "", getString(R.string.fingers_feeling)));
        symptomsData.add(new Text(3, "", "", getString(R.string.diarrhea_and)));
        symptomsData.add(new Text(5, "", "", ""));
        symptomsData.add(new Text(2, "", getString(R.string.day_7), ""));
        symptomsData.add(new Text(3, "", "", getString(R.string.higher_fever)));
        symptomsData.add(new Text(3, "", "", getString(R.string.couging)));
        symptomsData.add(new Text(3, "", "", getString(R.string.body_pain_headache)));
        symptomsData.add(new Text(3, "", "", getString(R.string.worsening)));
        symptomsData.add(new Text(3, "", "", getString(R.string.vomiting)));
        symptomsData.add(new Text(5, "", "", ""));
        symptomsData.add(new Text(2, "", getString(R.string.day_8), ""));
        symptomsData.add(new Text(3, "", "", getString(R.string.fever_arround)));
        symptomsData.add(new Text(3, "", "", getString(R.string.breathing_difficul)));
        symptomsData.add(new Text(3, "", "", getString(R.string.coughing)));
        symptomsData.add(new Text(3, "", "", getString(R.string.headaches_joints)));
        symptomsData.add(new Text(5, "", "", ""));
        symptomsData.add(new Text(2, "", getString(R.string.day_9), ""));
        symptomsData.add(new Text(3, "", "", getString(R.string.symptoms_remain)));
        symptomsData.add(new Text(3, "", "", getString(R.string.worsening_fever)));
        symptomsData.add(new Text(3, "", "", getString(R.string.worsening_cough)));
        symptomsData.add(new Text(3, "", "", getString(R.string.difficult_breath)));


        //Infected
        infectedData.add(new Text(1, getString(R.string.what_to_do), "", ""));
        infectedData.add(new Text(1, getString(R.string.steps_to_help), "", ""));
        infectedData.add(new Text(5, "", "", ""));
        infectedData.add(new Text(2, "", getString(R.string.stay_home), ""));
        infectedData.add(new Text(3, "", "", getString(R.string.stay_home_2)));
        infectedData.add(new Text(3, "", "", getString(R.string.avoid_public)));
        infectedData.add(new Text(3, "", "", getString(R.string.avoid_public_trans)));
        infectedData.add(new Text(5, "", "", ""));
        infectedData.add(new Text(2, "", getString(R.string.separate_yourself), ""));
        infectedData.add(new Text(3, "", "", getString(R.string.stay_away_from)));
        infectedData.add(new Text(3, "", "", getString(R.string.limit_contact)));
        infectedData.add(new Text(3, "", "", getString(R.string.when_possible)));
        infectedData.add(new Text(5, "", "", ""));
        infectedData.add(new Text(2, "", getString(R.string.call_ahead), ""));
        infectedData.add(new Text(3, "", "", getString(R.string.call_ahead_2)));
        infectedData.add(new Text(5, "", "", ""));
        infectedData.add(new Text(2, "", getString(R.string.wear_a_facemask), ""));
        infectedData.add(new Text(3, "", "", getString(R.string.if_you_are_sick)));
        infectedData.add(new Text(3, "", "", getString(R.string.if_you_are_caring)));
        infectedData.add(new Text(5, "", "", ""));
        infectedData.add(new Text(2, "", getString(R.string.cover_your_coughs), ""));
        infectedData.add(new Text(3, "", "", getString(R.string.cover_cover)));
        infectedData.add(new Text(3, "", "", getString(R.string.dispose)));
        infectedData.add(new Text(3, "", "", getString(R.string.wash_hands)));
        infectedData.add(new Text(5, "", "", ""));
        infectedData.add(new Text(2, "", getString(R.string.clean_your_hands), ""));
        infectedData.add(new Text(3, "", "", getString(R.string.wash_hands_2)));
        infectedData.add(new Text(3, "", "", getString(R.string.hand_sanitizer)));
        infectedData.add(new Text(3, "", "", getString(R.string.soap_and_water)));
        infectedData.add(new Text(3, "", "", getString(R.string.avoid_touching)));
        infectedData.add(new Text(5, "", "", ""));
        infectedData.add(new Text(2, "", getString(R.string.avoid_sharing), ""));
        infectedData.add(new Text(3, "", "", getString(R.string.do_not_share)));
        infectedData.add(new Text(3, "", "", getString(R.string.wash_throughly)));
        infectedData.add(new Text(5, "", "", ""));
        infectedData.add(new Text(2, "", getString(R.string.clean_all), ""));
        infectedData.add(new Text(3, "", "", getString(R.string.clean_and_disinfect)));
        infectedData.add(new Text(3, "", "", getString(R.string.high_touch)));
        infectedData.add(new Text(3, "", "", getString(R.string.disinfect)));
        infectedData.add(new Text(3, "", "", getString(R.string.household)));
        infectedData.add(new Text(5, "", "", ""));
        infectedData.add(new Text(2, "", getString(R.string.minitor_your_sym), ""));
        infectedData.add(new Text(3, "", "", getString(R.string.seek_medical)));
        infectedData.add(new Text(3, "", "", getString(R.string.call_your_doc)));
        infectedData.add(new Text(3, "", "", getString(R.string.wear_a_facemask_2)));
        infectedData.add(new Text(3, "", "", getString(R.string.alert_health)));

        //Precations
        precautionsData.add(new Text(1, getString(R.string.steps_to_protect), "", ""));
        precautionsData.add(new Text(5, "", "", ""));
        precautionsData.add(new Text(2, "", getString(R.string.clean_hands), ""));
        precautionsData.add(new Text(3, "", "", getString(R.string.wash_hands_3)));
        precautionsData.add(new Text(3, "", "", getString(R.string.soap_water)));
        precautionsData.add(new Text(3, "", "", getString(R.string.touchings)));
        precautionsData.add(new Text(5, "", "", ""));
        precautionsData.add(new Text(2, "", getString(R.string.avoid_close), ""));
        precautionsData.add(new Text(3, "", "", getString(R.string.avoid_close_2)));
        precautionsData.add(new Text(3, "", "", getString(R.string.put_distance)));
        precautionsData.add(new Text(5, "", "", ""));
        precautionsData.add(new Text(1, getString(R.string.steps_protect), "", ""));
        precautionsData.add(new Text(5, "", "", ""));
        precautionsData.add(new Text(2, "", getString(R.string.home_if), ""));
        precautionsData.add(new Text(3, "", "", getString(R.string.home_sick)));
        precautionsData.add(new Text(2, "", getString(R.string.cough_sneezes), ""));
        precautionsData.add(new Text(3, "", "", getString(R.string.mouth_and_nose)));
        precautionsData.add(new Text(3, "", "", getString(R.string.throu_tissues)));
        precautionsData.add(new Text(3, "", "", getString(R.string.immediately)));
        precautionsData.add(new Text(5, "", "", ""));
        precautionsData.add(new Text(2, "", getString(R.string.wear_face), ""));
        precautionsData.add(new Text(3, "", "", getString(R.string.should_wear)));
        precautionsData.add(new Text(3, "", "", getString(R.string.not_sick)));
        precautionsData.add(new Text(2, "", getString(R.string.clean_disinfect), ""));
        precautionsData.add(new Text(5, "", "", ""));
        precautionsData.add(new Text(3, "", "", getString(R.string.clean_and_disinfect_2)));
        precautionsData.add(new Text(3, "", "", getString(R.string.surfaces_are_dirty)));

        //History
        historyData.add(new Text(1, getString(R.string.Coronaviruses), "", ""));
        historyData.add(new Text(3, "", "", getString(R.string.corona_family)));
        historyData.add(new Text(5, "", "", ""));
        historyData.add(new Text(2, "", getString(R.string.virus_originate), ""));
        historyData.add(new Text(3, "", "", getString(R.string.coronavirus_comes)));
        historyData.add(new Text(3, "", "", getString(R.string.novel_coronavirus)));
        historyData.add(new Text(3, "", "", getString(R.string.chines_health)));
        historyData.add(new Text(3, "", "", getString(R.string.scientists)));
        historyData.add(new Text(5, "", "", ""));
        historyData.add(new Text(2, "", getString(R.string.the_symptoms), ""));
        historyData.add(new Text(3, "", "", getString(R.string.accourding_to_who)));
        historyData.add(new Text(3, "", "", getString(R.string.current_estimates)));
        historyData.add(new Text(5, "", "", ""));
        historyData.add(new Text(2, "", getString(R.string.how_deadly), ""));
        historyData.add(new Text(3, "", "", getString(R.string.with_more)));
        historyData.add(new Text(3, "", "", getString(R.string.while_new)));
        historyData.add(new Text(5, "", "", ""));
        historyData.add(new Text(2, "", getString(R.string.where_have_cases), ""));
        historyData.add(new Text(3, "", "", getString(R.string.most_cases)));
        historyData.add(new Text(3, "", "", getString(R.string.the_virus_has)));

        //Views initializtion
        statusBtn = findViewById(R.id.status_cv);
        checkerBtn = findViewById(R.id.checker_cv);
        symptomsBtn = findViewById(R.id.symptoms_cv);
        infectedBtn = findViewById(R.id.infected_cv);
        precautionsBtn = findViewById(R.id.precautions_cv);
        historyBtn = findViewById(R.id.history_cv);

        //listenters
        statusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StatusActivity.class));
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
        checkerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CheckerActivity.class));
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
        symptomsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TextActivity.class);
                intent.putExtra("data", symptomsData);
                intent.putExtra("title", getString(R.string.symptoms));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
        infectedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TextActivity.class);
                intent.putExtra("data", infectedData);
                intent.putExtra("title", getString(R.string.infected));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
        precautionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TextActivity.class);
                intent.putExtra("data", precautionsData);
                intent.putExtra("title", getString(R.string.precautions));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TextActivity.class);
                intent.putExtra("data", historyData);
                intent.putExtra("title", getString(R.string.history));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
    }
}

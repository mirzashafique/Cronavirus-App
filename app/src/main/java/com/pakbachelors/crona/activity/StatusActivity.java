package com.pakbachelors.crona.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pakbachelors.crona.R;
import com.pakbachelors.crona.T;
import com.pakbachelors.crona.adapter.CountryRecyclerViewAdapter;
import com.pakbachelors.crona.model.Staticts;
import com.pakbachelors.crona.network.WSResponse;
import com.pakbachelors.crona.network.WsManager;
import com.pakbachelors.crona.utils.JsonViewer;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StatusActivity extends AppCompatActivity {

    //Veriables
    private List<Staticts> data;
    private CountryRecyclerViewAdapter adapter;
    private WsManager wsManager;

    //Views
    private ImageView crossBtn;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        //veriables
        data = new ArrayList<>();
        wsManager = new WsManager(getApplicationContext());
        adapter = new CountryRecyclerViewAdapter(this, data);

        //Views
        progressBar = findViewById(R.id.progress_bar);
        crossBtn = findViewById(R.id.cross_im);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);


        crossBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
            }
        });
        getData();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    void getData() {
        wsManager.post("https://lab.isaaclin.cn//nCoV/api/area?latest=1", new WSResponse() {
            @Override
            public void onSuccess(String responce) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(responce);
                    if (jsonObject.getBoolean("success")) {
                        data.addAll(JsonViewer.parseDate(responce));
                        adapter.notifyDataSetChanged();
                    } else {
                        T.message(getApplicationContext(), "Sorry! Something went wrong...");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String error) {
                progressBar.setVisibility(View.GONE);
                T.message(getApplicationContext(), "Sorry! Something went wrong...");
            }
        });
    }
}

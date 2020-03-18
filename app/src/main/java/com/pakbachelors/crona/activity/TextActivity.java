package com.pakbachelors.crona.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pakbachelors.crona.R;
import com.pakbachelors.crona.adapter.TextRecyclerViewAdapter;
import com.pakbachelors.crona.model.Text;

import java.util.ArrayList;

public class TextActivity extends AppCompatActivity {

    //Veriables
    private ArrayList<Text> data;
    private TextRecyclerViewAdapter adapter;

    //Views
    private TextView title;
    private ImageView crossIm;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);


        //veriables
        data = new ArrayList<>();
        data = (ArrayList<Text>) getIntent().getSerializableExtra("data");
        adapter = new TextRecyclerViewAdapter(getApplicationContext(), data);

        //Views
        title = findViewById(R.id.title_tv);
        crossIm = findViewById(R.id.cross_im);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

        title.setText(getIntent().getStringExtra("title"));
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

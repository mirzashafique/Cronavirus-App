package com.pakbachelors.crona.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pakbachelors.crona.R;
import com.pakbachelors.crona.model.Checker;


public class PlaceholderFragment extends Fragment {

    private Checker checker;

    public PlaceholderFragment(Checker checker) {
        this.checker = checker;
    }


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main2, container, false);
        TextView title = root.findViewById(R.id.title_tv);
        title.setText(checker.getDisease());
        TextView description = root.findViewById(R.id.description_tv);
        description.setText(checker.getDiscription());
        final ImageView yesIm = root.findViewById(R.id.yes_im);
        final ImageView noIm = root.findViewById(R.id.no_im);
        LinearLayout yesLayout = root.findViewById(R.id.yes_tv);
        LinearLayout noLayout = root.findViewById(R.id.no_tv);

        if (checker.isChecked()) {
            if (checker.isAvailable()) {
                yesIm.setImageResource(R.drawable.ic_tick);
                noIm.setImageResource(R.drawable.ic_circle);
            } else {
                noIm.setImageResource(R.drawable.ic_tick);
                yesIm.setImageResource(R.drawable.ic_circle);
            }
        } else {

        }

        yesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesIm.setImageResource(R.drawable.ic_tick);
                noIm.setImageResource(R.drawable.ic_circle);
                checker.setAvailable(true);
                checker.setChecked(true);
            }
        });
        noLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noIm.setImageResource(R.drawable.ic_tick);
                yesIm.setImageResource(R.drawable.ic_circle);
                checker.setAvailable(false);
                checker.setChecked(true);
            }
        });


        return root;
    }
}
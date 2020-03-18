package com.pakbachelors.crona.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pakbachelors.crona.R;
import com.pakbachelors.crona.activity.StatusDetailActivity;
import com.pakbachelors.crona.model.Staticts;

import java.util.List;

public class CountryRecyclerViewAdapter extends RecyclerView.Adapter<CountryRecyclerViewAdapter.MyViewHolder> {

    private Activity context;
    private List<Staticts> data;
    private LayoutInflater inflater;

    public CountryRecyclerViewAdapter(Activity context, List<Staticts> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row_for_country_rv_adapter, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Staticts current = data.get(position);
        holder.countryName.setText(current.getCountryEnglishName());
        holder.continentName.setText(current.getContinentEnglishName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, StatusDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("data",current);
                context.startActivity(intent);
                context.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView countryName, continentName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.country_tv);
            continentName = itemView.findViewById(R.id.continent_tv);
        }
    }
}

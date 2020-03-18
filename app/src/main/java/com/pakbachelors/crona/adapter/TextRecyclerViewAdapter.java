package com.pakbachelors.crona.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pakbachelors.crona.R;
import com.pakbachelors.crona.model.Text;

import java.util.List;

public class TextRecyclerViewAdapter extends RecyclerView.Adapter {

    public final static int MAIN_HEADING = 1;
    public final static int SUB_HEADING = 2;
    public final static int SIMPLE_TXT = 3;
    public final static int SPACE_TXT = 5;


    private Context context;
    private List<Text> data;
    private LayoutInflater inflater;

    public TextRecyclerViewAdapter(Context context, List<Text> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        Text current = data.get(position);
        if (current.getType() == MAIN_HEADING) {
            return MAIN_HEADING;
        } else if (current.getType() == SUB_HEADING) {
            return SUB_HEADING;
        } else if (current.getType() == SPACE_TXT) {
            return SPACE_TXT;
        } else {
            return SIMPLE_TXT;
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MAIN_HEADING) {
            View view = inflater.inflate(R.layout.custom_row_for_main_heading_rv_adapter, parent, false);
            return new MainHeadingViewHolder(view);
        } else if (viewType == SUB_HEADING) {
            View view = inflater.inflate(R.layout.custom_row_for_sub_heading_rv_adapter, parent, false);
            return new SubHeadingViewHolder(view);
        } else if (viewType == SPACE_TXT) {
            View view = inflater.inflate(R.layout.custom_row_for_space_rv_adapter, parent, false);
            return new SpaceViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.custom_row_for_txt_rv_adapter, parent, false);
            return new SimpleHeadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Text current = data.get(position);
        // O61b_df9

        switch (holder.getItemViewType()) {
            case MAIN_HEADING: {
                ((MainHeadingViewHolder) holder).bind(current, context, position);
                break;
            }
            case SUB_HEADING: {
                ((SubHeadingViewHolder) holder).bind(current, context, position);
                break;
            }
            case SPACE_TXT: {
                ((SpaceViewHolder) holder).bind(current, context, position);
                break;
            }
            case SIMPLE_TXT: {
                ((SimpleHeadingViewHolder) holder).bind(current, context, position);
                break;
            }
        }
    }


    protected class MainHeadingViewHolder extends RecyclerView.ViewHolder {
        private TextView text;

        public MainHeadingViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.txt_tv);
        }

        public void bind(final Text post, Context context, int position) {
            text.setText(post.getMainHeading());
        }
    }

    protected class SubHeadingViewHolder extends RecyclerView.ViewHolder {
        private TextView text;

        public SubHeadingViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.txt_tv);
        }

        public void bind(final Text post, Context context, int position) {
            text.setText(post.getSubHeading());
        }


    }

    protected class SimpleHeadingViewHolder extends RecyclerView.ViewHolder {
        private TextView text;

        public SimpleHeadingViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.txt_tv);
        }

        public void bind(final Text post, Context context, int position) {
            text.setText(post.getSimpleHeading());
        }

    }

    protected class SpaceViewHolder extends RecyclerView.ViewHolder {


        public SpaceViewHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void bind(final Text post, Context context, int position) {
        }

    }
}






package com.catalift.android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.catalift.android.Model.Explore;
import com.catalift.android.R;

import java.util.ArrayList;
import java.util.List;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder> {
    private Context context;
    private List<Explore> exploreList;
    private List<Explore> exploreListFull;


    public ExploreAdapter(Context context, List<Explore> exploreList) {
        this.context = context;
        this.exploreList = exploreList;
        this.exploreListFull = new ArrayList<>(exploreList);
    }

    public void filter(String text) {
        exploreList.clear();
        if (text.isEmpty()) {
            exploreList.addAll(exploreListFull);
        } else {
            String query = text.toLowerCase();
            for (Explore item : exploreListFull) {
                if (item.getName().toLowerCase().contains(query)) {
                    exploreList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public ExploreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mentor_card, parent, false);
        return new ExploreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExploreViewHolder holder, int position) {
        Explore item = exploreList.get(position);

        holder.pic.setImageResource(item.getPic());
        holder.rating.setText(item.getRating());
        holder.department.setText(item.getDepartment());
        holder.name.setText(item.getName());
        holder.years.setText(item.getYears());
        holder.position.setText(item.getPosition());
        holder.review.setText(item.getReview());
        holder.description.setText(item.getDescription());
        holder.compatibility.setText(item.getCompatability());
    }

    @Override
    public int getItemCount() {
        return exploreList.size();
    }

    public class ExploreViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView rating, department, name, years, position, review, description, compatibility;

        public ExploreViewHolder(View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.pic);
            rating = itemView.findViewById(R.id.rating);
            department = itemView.findViewById(R.id.department);
            name = itemView.findViewById(R.id.name);
            years = itemView.findViewById(R.id.years);
            position = itemView.findViewById(R.id.position);
            review = itemView.findViewById(R.id.review);
            description = itemView.findViewById(R.id.description);
            compatibility = itemView.findViewById(R.id.compatibility);
        }
    }
}

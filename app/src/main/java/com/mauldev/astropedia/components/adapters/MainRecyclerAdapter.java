package com.mauldev.astropedia.components.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mauldev.astropedia.R;
import com.mauldev.astropedia.models.ConstellationModel;
import com.mauldev.astropedia.screen.constellationDetail.ConstellationDetailActivity;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<ConstellationModel> constellationModelList;

    public MainRecyclerAdapter(Context context, List<ConstellationModel> constellationModelList) {
        this.context = context;
        this.constellationModelList = constellationModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.layout_recyclerview_main,viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.listViewCosntNameTV.setText(constellationModelList.get(i).getName());
        viewHolder.maxStarTV.setText("Main Stars: "+String.valueOf(constellationModelList.get(i).getTotalStar()));

        /*Check if star constellation can be observed
          with naked eyes*/
        if (constellationModelList.get(i).isVisibleWithNakedEye()){
            viewHolder.isPossibleToObserveTV.setText("It's possible to observe with naked eyes");
            viewHolder.isPossibleToObserveTV.setTextColor(context.getResources().getColor(R.color.green));
        }else {
            viewHolder.isPossibleToObserveTV.setText("It's impossible to observe with naked eyes");
            viewHolder.isPossibleToObserveTV.setTextColor(context.getResources().getColor(R.color.red));
        }

        /*Check if image is available*/
        if (!constellationModelList.get(i).getIllustrationImageUrl().equals("")){
            Glide.with(context).load(constellationModelList.get(i).getIllustrationImageUrl()).into(viewHolder.listViewIV);
        }else{
            viewHolder.listViewIV.setBackgroundColor(context.getResources().getColor(R.color.grey));
        }

        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ConstellationDetailActivity.class);
                intent.putExtra("constellation",constellationModelList.get(i));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return constellationModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView listViewIV;
        public TextView listViewCosntNameTV;
        public TextView maxStarTV;
        public TextView isPossibleToObserveTV;
        public View layout;

        public ViewHolder(View itemView) {
            super(itemView);
            layout = itemView;
            listViewCosntNameTV = itemView.findViewById(R.id.listViewCosntNameTV);
            listViewIV = itemView.findViewById(R.id.listViewIV);
            maxStarTV = itemView.findViewById(R.id.listViewMainStarTV);
            isPossibleToObserveTV = itemView.findViewById(R.id.isPossibleToObserveTV);
        }
    }
}

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

public class GridViewMainRecyclerAdapter extends RecyclerView.Adapter<GridViewMainRecyclerAdapter.ViewHolder> {

    private List<ConstellationModel> constellationModelList;
    private Context context;

    public GridViewMainRecyclerAdapter(Context context, List<ConstellationModel> constellationModels) {
        this.context = context;
        this.constellationModelList = constellationModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.layout_recyclerview_grid_main,viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.constNameTV.setText(constellationModelList.get(i).getName());

        /*Check if image is available*/
        if (!constellationModelList.get(i).getIllustrationImageUrl().equals("")){
            Glide.with(context).load(constellationModelList.get(i).getIllustrationImageUrl()).into(viewHolder.gridViewIV);
        }else{
            viewHolder.gridViewIV.setBackgroundColor(context.getResources().getColor(R.color.grey));
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
        public ImageView gridViewIV;
        public TextView constNameTV;
        public View layout;

        public ViewHolder(View itemView) {
            super(itemView);
            layout = itemView;
            gridViewIV = itemView.findViewById(R.id.gridviewConstIV);
            constNameTV = itemView.findViewById(R.id.gridviewConstNameTV);
        }
    }
}

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

public class CardViewMainRecyclerAdapter extends RecyclerView.Adapter<CardViewMainRecyclerAdapter.ViewHolder>{

    private Context context;
    private List<ConstellationModel> constellationModelList;

    public CardViewMainRecyclerAdapter(Context context, List<ConstellationModel> constellationModelList) {
        this.context = context;
        this.constellationModelList = constellationModelList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.layout_recyclerview_card_main,viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.constNameTV.setText(constellationModelList.get(i).getName());
        viewHolder.mainStarTV.setText("Main stars: "+String.valueOf(constellationModelList.get(i).getTotalStar()));

        /*Check if image is available*/
        if (!constellationModelList.get(i).getIllustrationImageUrl().equals("")){
            Glide.with(context).load(constellationModelList.get(i).getIllustrationImageUrl()).into(viewHolder.cardMainIV);
        }else{
            viewHolder.cardMainIV.setBackgroundColor(context.getResources().getColor(R.color.grey));
        }

        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ConstellationDetailActivity.class);
                intent.putExtra("constellation",constellationModelList.get(i));
                context.startActivity(intent);
            }
        });

        viewHolder.cardMainFavIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewHolder.isFavorited){
                    viewHolder.cardMainFavIV.setImageResource(R.drawable.ic_star_border_grey_24dp);
                    Toast.makeText(context, constellationModelList.get(i).getName()+" Unfavorited", Toast.LENGTH_SHORT).show();
                } else {
                    viewHolder.cardMainFavIV.setImageResource(R.drawable.ic_star_yellow_24dp);
                    Toast.makeText(context, constellationModelList.get(i).getName()+" Favorited", Toast.LENGTH_SHORT).show();
                }
                viewHolder.isFavorited = !viewHolder.isFavorited;
            }
        });
    }


    @Override
    public int getItemCount() {
        return constellationModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView cardMainIV;
        public ImageView cardMainFavIV;
        public TextView constNameTV;
        public TextView mainStarTV;
        public View layout;

        public boolean isFavorited;

        public ViewHolder(View itemView) {
            super(itemView);
            isFavorited = false;
            layout = itemView;
            cardMainIV = itemView.findViewById(R.id.mainCardIV);
            cardMainFavIV = itemView.findViewById(R.id.mainCardFavIV);
            constNameTV = itemView.findViewById(R.id.mainCardNameTV);
            mainStarTV = itemView.findViewById(R.id.mainCardTotalStarTV);
        }
    }
}

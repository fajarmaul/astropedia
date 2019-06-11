package com.mauldev.astropedia.screen.constellationDetail;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mauldev.astropedia.R;
import com.mauldev.astropedia.models.ConstellationModel;

public class ConstellationDetailActivity extends AppCompatActivity {

    private ConstellationModel constellationModel;
    private TextView detailConstCardBestViewTV, detailConstMainStarsTV, shortDescriptionTV;
    private ImageView collapsibleToolbarIV, detailConstCardIV;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Button checkWikipediaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constellation_detail);

        bindView();
        initialize();
    }

    private void bindView() {
//        constellationDetailNameTV = findViewById(R.id.constellationDetailNameTV);
        collapsibleToolbarIV = findViewById(R.id.detailConstellationToolbarImage);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        detailConstCardIV = findViewById(R.id.detailConstCardIV);
        detailConstCardBestViewTV = findViewById(R.id.detailConstCardBestViewTV);
        detailConstMainStarsTV = findViewById(R.id.detailConstMainStarsTV);
        shortDescriptionTV = findViewById(R.id.shortDescriptionTV);
        checkWikipediaButton = findViewById(R.id.checkWikipediaButton);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp, null));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initialize() {

        try {
            constellationModel = getIntent().getParcelableExtra("constellation");
        }catch (NullPointerException e){
            constellationModel = new ConstellationModel();
            constellationModel.setName("Empty constellation");
        }

//        constellationDetailNameTV.setText(constellationModel.getName());
        Glide.with(this).load(constellationModel.getIllustrationImageUrl()).into(collapsibleToolbarIV);
        collapsingToolbarLayout.setTitle(constellationModel.getName());
        detailConstCardBestViewTV.setText(constellationModel.getBestViewMonthorSeason());
        detailConstMainStarsTV.setText(String.valueOf(constellationModel.getTotalStar()));
        shortDescriptionTV.setText(constellationModel.getShortDescription());

        /*Check if image is available*/
        if (!constellationModel.getObservationImageUrl().equals("")){
            Glide.with(this).load(constellationModel.getObservationImageUrl()).into(detailConstCardIV);
        }else{
            detailConstCardIV.setBackgroundColor(getResources().getColor(R.color.grey));
        }

        checkWikipediaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(constellationModel.getWikipediaUrl()));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

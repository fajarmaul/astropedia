package com.mauldev.astropedia.screen.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mauldev.astropedia.R;
import com.mauldev.astropedia.components.adapters.CardViewMainRecyclerAdapter;
import com.mauldev.astropedia.components.adapters.GridViewMainRecyclerAdapter;
import com.mauldev.astropedia.components.adapters.MainRecyclerAdapter;
import com.mauldev.astropedia.datas.ConstellationDataSeeder;
import com.mauldev.astropedia.models.ConstellationModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRV;
    private List<ConstellationModel> constellationModelList;
    private ConstellationDataSeeder dataSeeder;
    private MainRecyclerAdapter listMainRecyclerAdapter;
    private GridViewMainRecyclerAdapter gridViewMainRecyclerAdapter;
    private CardViewMainRecyclerAdapter cardViewMainRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        initialize();
    }

    private void bindView() {
        mainRV = findViewById(R.id.mainRV);
    }

    private void initialize() {
        dataSeeder = new ConstellationDataSeeder();
        constellationModelList = new ArrayList<>();
        constellationModelList = dataSeeder.generateData();

        showListView();
    }

    private void showListView() {
        listMainRecyclerAdapter = new MainRecyclerAdapter(this,constellationModelList);
        mainRV.setLayoutManager(new LinearLayoutManager(this));
        mainRV.setAdapter(listMainRecyclerAdapter);
    }

    private void showGridView(){
        gridViewMainRecyclerAdapter = new GridViewMainRecyclerAdapter(this,constellationModelList);
        mainRV.setLayoutManager(new GridLayoutManager(this,2));
        mainRV.setAdapter(gridViewMainRecyclerAdapter);
    }

    private void showCardView(){
        cardViewMainRecyclerAdapter = new CardViewMainRecyclerAdapter(this, constellationModelList);
        mainRV.setLayoutManager(new LinearLayoutManager(this));
        mainRV.setAdapter(cardViewMainRecyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.listView:
                showListView();
                break;

            case R.id.gridView:
                showGridView();
                break;

            case R.id.cardView:
                showCardView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

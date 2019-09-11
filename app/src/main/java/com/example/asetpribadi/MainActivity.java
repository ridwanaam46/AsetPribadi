package com.example.asetpribadi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.asetpribadi.adapter.CardViewAdapter;
import com.example.asetpribadi.adapter.GridViewAdapter;
import com.example.asetpribadi.adapter.ListViewAdapter;
import com.example.asetpribadi.object.AsetPribadi;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridViewAdapter gridViewAdapter;
    private CardViewAdapter cardViewAdapter;
    private ListViewAdapter listViewAdapter;

    private ArrayList<AsetPribadi> arrayListTeam = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardViewAdapter = new CardViewAdapter(this);
        gridViewAdapter = new GridViewAdapter(this);
        listViewAdapter = new ListViewAdapter(this);

        recyclerView = findViewById(R.id.recycler_view);

        arrayListTeam.add(new AsetPribadi("Hardisk", R.drawable.hardisk));
        arrayListTeam.add(new AsetPribadi("Gelas", R.drawable.gelas));
        arrayListTeam.add(new AsetPribadi("Flashdisk", R.drawable.flashdisk));
        arrayListTeam.add(new AsetPribadi("Gitar", R.drawable.gitar));
        arrayListTeam.add(new AsetPribadi("Buku", R.drawable.buku));
        arrayListTeam.add(new AsetPribadi("Charger", R.drawable.charger));
        arrayListTeam.add(new AsetPribadi("Jaket", R.drawable.jaket));
        arrayListTeam.add(new AsetPribadi("Kipas", R.drawable.kpias));
        arrayListTeam.add(new AsetPribadi("Tip-x", R.drawable.tipx));
        arrayListTeam.add(new AsetPribadi("Pulpen", R.drawable.pulpen));
        arrayListTeam.add(new AsetPribadi("Speaker", R.drawable.speaker));

        setListView();

    }

    private void setGridView(){
        setTitle(R.string.title_mode_grid_view);
        gridViewAdapter.addItem(arrayListTeam);
        gridViewAdapter.setLayoutType(R.layout.content_item_grid);
        recyclerView.setAdapter(gridViewAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void setCardView(){
        setTitle(R.string.title_mode_card_view);
        cardViewAdapter.addItem(arrayListTeam);
        cardViewAdapter.setLayoutType(R.layout.content_item_card);
        recyclerView.setAdapter(cardViewAdapter);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setListView(){
        setTitle(R.string.title_mode_list_view);
        listViewAdapter.addItem(arrayListTeam);
        listViewAdapter.setLayoutType(R.layout.content_item_list);
        recyclerView.setAdapter(listViewAdapter);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void intentAboutMe(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.toolbar_card_view:
                setCardView();
                break;

            case R.id.toolbar_about_me:
                intentAboutMe();
                break;

            case R.id.toolbar_list_view:
                setListView();
                break;

            case R.id.toolbar_grid_view:
                setGridView();
                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}


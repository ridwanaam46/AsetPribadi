package com.example.asetpribadi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asetpribadi.object.AsetPribadi;
import com.squareup.picasso.Picasso;

public class Detail extends AppCompatActivity {

    public final static String EXTRA_TEAM = "EXTRA_TEAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle(getString(R.string.title_detail_aset));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textViewName = findViewById(R.id.textview_detail_name);
        ImageView imageViewStadium = findViewById(R.id.poster);

        AsetPribadi extraTeam = getIntent().getParcelableExtra(EXTRA_TEAM);
        textViewName.setText(extraTeam.getMerk());
        Picasso.get().load(extraTeam.getIntGambar()).into(imageViewStadium);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();

        if (i == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}

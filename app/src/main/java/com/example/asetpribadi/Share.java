package com.example.asetpribadi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asetpribadi.object.AsetPribadi;
import com.squareup.picasso.Picasso;

public class Share extends AppCompatActivity {

    public final static String EXTRA_TEAM = "EXTRA_TEAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        setTitle(getString(R.string.title_shared_aset));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ImageView imageViewStadium = findViewById(R.id.imageView);

        AsetPribadi extraTeam = getIntent().getParcelableExtra(EXTRA_TEAM);
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

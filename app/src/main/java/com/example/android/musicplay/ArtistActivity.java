package com.example.android.musicplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_list);

        final ArrayList<Artist> artist = new ArrayList<Artist>();
        artist.add(new Artist("Alex Schulz", R.drawable.alex));
        artist.add(new Artist("Armin", R.drawable.armin));
        artist.add(new Artist("Avicii", R.drawable.avicii));
        artist.add(new Artist("Jason Derulo", R.drawable.jason));
        artist.add(new Artist("Kygo", R.drawable.kygo));
        artist.add(new Artist("Martin Garrix", R.drawable.martin));

        ArtistAdapter adapter = new ArtistAdapter(this, artist);

        ListView listView = (ListView) findViewById(R.id.list_artist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Artist art = artist.get(position);
                if (art.getmArtistName() == "Alex Schulz") {
                    Intent playerIntent = new Intent(ArtistActivity.this, AlexActivity.class);
                    startActivity(playerIntent);
                }
                if (art.getmArtistName() == "Armin") {
                    Intent playerIntent = new Intent(ArtistActivity.this, ArminActivity.class);
                    startActivity(playerIntent);
                }
                if (art.getmArtistName() == "Avicii") {
                    Intent playerIntent = new Intent(ArtistActivity.this, AviciiActivity.class);
                    startActivity(playerIntent);
                }
                if (art.getmArtistName() == "Jason Derulo") {
                    Intent playerIntent = new Intent(ArtistActivity.this, JasonActivity.class);
                    startActivity(playerIntent);
                }
                if (art.getmArtistName() == "Kygo") {
                    Intent playerIntent = new Intent(ArtistActivity.this, KygoActivity.class);
                    startActivity(playerIntent);
                }
                if (art.getmArtistName() == "Martin Garrix") {
                    Intent playerIntent = new Intent(ArtistActivity.this, MartinActivity.class);
                    startActivity(playerIntent);
                }
            }
        });

        //button to move to the AllSongs Activity
        Button goAllSongs = findViewById(R.id.goToAllSongs);
        goAllSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ArtistActivity.this, MusicActivity.class);
                startActivity(intent);
            }
        });

    }

}

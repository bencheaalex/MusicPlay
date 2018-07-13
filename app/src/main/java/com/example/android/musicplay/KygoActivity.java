package com.example.android.musicplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class KygoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Never let you go", "Kygo", R.raw.kygo_never_let_you_go, R.drawable.never));
        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list_song);
        listView.setAdapter(adapter);

        //Click listener that open the Activity of the artist and sends the song parameters to the new intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Song song = songs.get(position);
                Intent playerIntent = new Intent(KygoActivity.this, PlayerActivity.class);
                playerIntent.putExtra("getSongName", song.getSongName());
                playerIntent.putExtra("getArtistName", song.getArtistName());
                playerIntent.putExtra("getAudioResourceId", song.getAudioResourceId());
                playerIntent.putExtra("getImageResourceId", song.getImageResourceID());
                startActivity(playerIntent);
            }
        });

    }

}

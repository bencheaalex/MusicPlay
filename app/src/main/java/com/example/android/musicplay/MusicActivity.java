package com.example.android.musicplay;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("In the morning light", "Alex Schulz", R.raw.alex_schulz_in_the_morning_light, R.drawable.morning));
        songs.add(new Song("Summer night", "Alex Schulz", R.raw.alex_schulz_summer_night, R.drawable.summer));
        songs.add(new Song("Alone", "Armin", R.raw.armin_alone, R.drawable.alone));
        songs.add(new Song("Another you", "Armin", R.raw.armin_another_you, R.drawable.another));
        songs.add(new Song("This is what it feels like", "Armin", R.raw.armin_this_is_what_it_feels_like, R.drawable.thisis));
        songs.add(new Song("Addicted to you", "Avicii", R.raw.avicii_addicted_to_you, R.drawable.addicted));
        songs.add(new Song("Lonely together", "Avicii", R.raw.avicii_lonely_together, R.drawable.lonley));
        songs.add(new Song("If I'm lucky", "Jason Derulo", R.raw.jason_derulo_if_im_lucky, R.drawable.iflucky));
        songs.add(new Song("Tip Toe", "Jason Derulo", R.raw.jason_derulo_tip_toe, R.drawable.tiptoe));
        songs.add(new Song("Never let you go", "Kygo", R.raw.kygo_never_let_you_go, R.drawable.never));
        songs.add(new Song("In the name of love", "Martig Garrix", R.raw.martin_garrix_in_the_name_of_love, R.drawable.love));
        songs.add(new Song("Lions in the wild", "Martin Garrix", R.raw.martin_garrix_lions_in_the_wild, R.drawable.lions));

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list_music);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Song song = songs.get(position);
                Intent playerIntent = new Intent(MusicActivity.this, PlayerActivity.class);
                playerIntent.putExtra("getSongName", song.getSongName());
                playerIntent.putExtra("getArtistName", song.getArtistName());
                playerIntent.putExtra("getAudioResourceId", song.getAudioResourceId());
                playerIntent.putExtra("getImageResourceId", song.getImageResourceID());
                startActivity(playerIntent);
            }
        });

        //button to move to the Artist Activity
        Button goArtists = findViewById(R.id.goToArtists);
        goArtists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MusicActivity.this, ArtistActivity.class);
                startActivity(intent);
            }
        });

    }

}

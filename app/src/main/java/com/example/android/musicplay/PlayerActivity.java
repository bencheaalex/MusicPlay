package com.example.android.musicplay;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    boolean sPause, sPlay, sStop;

    @Override
    public void onBackPressed() {
        mMediaPlayer.stop();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        TextView songPlayer = (TextView) findViewById(R.id.song_in_player);
        songPlayer.setText(getIntent().getExtras().getString("getSongName"));

        TextView artistPlayer = (TextView) findViewById(R.id.artist_in_player);
        artistPlayer.setText(getIntent().getExtras().getString("getArtistName"));

        ImageView imagePlayer = (ImageView) findViewById(R.id.player_image);
        imagePlayer.setImageResource(getIntent().getExtras().getInt("getImageResourceId"));

        final int mAudioResourceId = getIntent().getExtras().getInt("getAudioResourceId");

        final Button pauseButton = (Button) findViewById(R.id.pause_view);
        final Button playButton = (Button) findViewById(R.id.play_view);
        final Button stopButton = (Button) findViewById(R.id.stop_view);

        playButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);

        mMediaPlayer = MediaPlayer.create(PlayerActivity.this, mAudioResourceId);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.start();
                playButton.setEnabled(false);
                pauseButton.setEnabled(true);
                stopButton.setEnabled(true);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.stop();
                mMediaPlayer = MediaPlayer.create(PlayerActivity.this, mAudioResourceId);
                playButton.setEnabled(true);
                pauseButton.setEnabled(false);
                stopButton.setEnabled(false);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.pause();
                playButton.setEnabled(true);
                pauseButton.setEnabled(false);
                stopButton.setEnabled(true);
            }
        });

    }

}

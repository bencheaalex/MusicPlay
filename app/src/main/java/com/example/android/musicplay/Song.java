package com.example.android.musicplay;

//class that defines a Song
public class Song {

    private String mSongName;
    private String mArtistName;
    private int mAudioResourceId;
    private int mImageResourceId;

    public Song(String songName, String artistName, int audioResourceId, int imageResourceId) {
        mSongName = songName;
        mArtistName = artistName;
        mAudioResourceId = audioResourceId;
        mImageResourceId = imageResourceId;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public int getImageResourceID() {
        return mImageResourceId;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }

}

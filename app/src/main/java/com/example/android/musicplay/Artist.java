package com.example.android.musicplay;

//class that defines an Artist
public class Artist {

    private String mArtistName;
    private int mImageResourceId;

    public Artist(String artistName, int imageResourceId) {
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
}

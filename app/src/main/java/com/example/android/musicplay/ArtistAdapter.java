package com.example.android.musicplay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    public ArtistAdapter(Context context, ArrayList<Artist> artisti) {
        super(context, 0, artisti);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_artist, parent, false);
        }
        Artist currentArtist = getItem(position);
        TextView artistName = (TextView) listItemView.findViewById(R.id.artist_view_artist);
        artistName.setText(currentArtist.getmArtistName());
        ImageView artistImage = (ImageView) listItemView.findViewById(R.id.image_view_artist);
        artistImage.setImageResource(currentArtist.getmImageResourceId());
        return listItemView;
    }

}

package com.the42apps.imageloaders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.the42apps.imageloaders.view.ViewHolder;

public class ImageLoaderAdapter extends ArrayAdapter<String> {

    private final LayoutInflater mInflater;
    private int mResource;

    public ImageLoaderAdapter(Context context, int resource) {
        super(context, resource);
        mResource = resource;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(mResource, parent, false);
        }

        ImageView imageView = ViewHolder.get(convertView, R.id.image);

        // TODO step2,3,4
        return convertView;
    }
}

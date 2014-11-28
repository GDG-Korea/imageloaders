package com.the42apps.imageloaders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.the42apps.imageloaders.view.MyBlueTransformations;
import com.the42apps.imageloaders.view.MyFirstCropTransformations;
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

        ViewPropertyAnimation.Animator animator = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                ViewPropertyAnimatorUtil.startAwesomeAnimation(view);
            }
        };

        // TODO step2,3,4
        String url = getItem(position);

        return convertView;
    }
}

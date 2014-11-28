package com.the42apps.imageloaders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.the42apps.imageloaders.data.ImageURLs;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends ListFragment {

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        setHasOptionsMenu(true);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageLoaderAdapter adapter
                = new ImageLoaderAdapter(getActivity(), R.layout.list_item);
        adapter.addAll(ImageURLs.URLS);
        setListAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.my_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_reset) {
            AppUtil.restartApp(getActivity());
            return true;
        } else if (item.getItemId() == R.id.menu_download) {
            downloadImage();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void downloadImage() {

        final String imaeUrl = ImageURLs.URLS[1];

        // TODO - step 7
        Glide.with(this).fromString().asBitmap().load(imaeUrl).into(new SimpleTarget<Bitmap>(800, 600) {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                resource.compress(Bitmap.CompressFormat.JPEG, 80, os);
                byte[] array = os.toByteArray();

                try {
                    File file = new File(getActivity().getCacheDir(), imaeUrl + ".jpg");
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(array, 0, array.length);
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

package com.nguyendungdeveloper.foodyversion20.controller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.nguyendungdeveloper.foodyversion20.R;

import java.io.InputStream;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;


    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();

        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        if(result==null)
        {
            bmImage.setImageResource(R.drawable.notimage);
        }
        else
        {
        bmImage.setImageBitmap(result);}
    }
}
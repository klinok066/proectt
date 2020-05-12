package com.example.albom4ik;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class PicAdapter extends BaseAdapter {
    int defaultItemBackground;

    //gallery context
    private Context galleryContext;

    //array to store bitmaps to display
    private Bitmap[] imageBitmaps;

    //placeholder bitmap for empty spaces in gallery
    Bitmap placeholder;
    public PicAdapter(Context c) {

        //instantiate context
        galleryContext = c;

        //create bitmap array
        imageBitmaps  = new Bitmap[10];

        //decode the placeholder image
        placeholder = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.ic_launcher_background);

        //more processing
        for(int i=0; i<imageBitmaps.length; i++)
            imageBitmaps[i]=placeholder;
        //get the styling attributes - use default Andorid system resources
        TypedArray styleAttrs = galleryContext.obtainStyledAttributes(R.styleable.PicGallery);

//get the background resource
        defaultItemBackground = styleAttrs.getResourceId(
                R.styleable.PicGallery_android_galleryItemBackground, 0);

//recycle attributes
        styleAttrs.recycle();
    }

    public int getCount() {
        return imageBitmaps.length;
    }

    public Object getItem(int position) {
        return position;
    }

    //return item ID at specified position
    public long getItemId(int position) {
        return position;
    }
    
    //get view specifies layout and display options for each thumbnail in the gallery
    public View getView(int position, View convertView, ViewGroup parent) {

        //create the view
        ImageView imageView = new ImageView(galleryContext);
        //specify the bitmap at this position in the array
        imageView.setImageBitmap(imageBitmaps[position]);
        //set layout options
        imageView.setLayoutParams(new Gallery.LayoutParams(300, 200));
        //scale type within view area
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        //set default gallery item background
        imageView.setBackgroundResource(defaultItemBackground);
        //return the view
        return imageView;
    }
}


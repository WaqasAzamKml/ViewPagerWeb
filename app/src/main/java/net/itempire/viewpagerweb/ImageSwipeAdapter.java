package net.itempire.viewpagerweb;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by MIRSAAB on 3/1/2017.
 */

/**
 * IMPORTANT : This class is not being used anymore.
 */
public class ImageSwipeAdapter extends PagerAdapter {
    String[] imageURIStrings = {"https://www.pakpets.com/uploads/ad_19393335700762.jpg",
            "https://www.pakpets.com/uploads/ad_19663014620032.jpg",
            "https://www.pakpets.com/uploads/ad_19653112584040.jpg"};
    //int[] imageResources = {R.drawable.pet_image_1, R.drawable.pet_image_2, R.drawable.pet_image_3};
    Context context;
    LayoutInflater layoutInflater;
    ImageView imgPet;
    ProgressBar progressBar;

    public ImageSwipeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageURIStrings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (FrameLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.image_swipe_layout, container, false);
        imgPet = (ImageView) v.findViewById(R.id.imgPetPhoto);
        progressBar = (ProgressBar) v.findViewById(R.id.pbImage);
        //imgPet.setImageResource(imageResources[position]);

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true).cacheOnDisk(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(defaultOptions).build();
        ImageLoader.getInstance().init(config); // Do it on Application start

        String imgURL = imageURIStrings[position];
        // Then later, when you want to display image
        ImageLoader.getInstance().displayImage(imgURL, imgPet, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(View.GONE);
            }
        });

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((FrameLayout)object);
    }
}

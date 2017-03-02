package net.itempire.viewpagerweb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by MIRSAAB on 3/2/2017.
 */

public class ImageSwipeFragment extends Fragment{
    ImageView imgPetPhoto;
    ProgressBar pbImage;
    int imageNumber = 0;
    String[] imageURIStrings = {"https://www.pakpets.com/uploads/ad_19393335700762.jpg",
            "https://www.pakpets.com/uploads/ad_19663014620032.jpg",
            "https://www.pakpets.com/uploads/ad_19653112584040.jpg"};
//    String[] imageURIStrings = {"drawable://"+R.drawable.pet_image_1,
//        "drawable://"+R.drawable.pet_image_2,
//        "drawable://"+R.drawable.pet_image_3};

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.image_swipe_layout, container, false);

        imgPetPhoto = (ImageView) v.findViewById(R.id.imgPetPhoto);
        pbImage = (ProgressBar) v.findViewById(R.id.pbImage);

        imgPetPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(), FullScreenImage.class);
                imgPetPhoto.buildDrawingCache();
                Bitmap imgPass = imgPetPhoto.getDrawingCache();
                Bundle extras = new Bundle();
                extras.putParcelable("petImage", imgPass);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        String imgURL = imageURIStrings[imageNumber];
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true).cacheOnDisk(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity().getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions).build();
        ImageLoader.getInstance().init(config); // Do it on Application start

        // Then later, when you want to display image
        ImageLoader.getInstance().displayImage(imgURL, imgPetPhoto, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                pbImage.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                pbImage.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                pbImage.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                pbImage.setVisibility(View.GONE);
            }
        }); // Default options will be used
        return v;
    } // End of onCreateView
}
package net.itempire.viewpagerweb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SingleView extends Fragment {

    ImageView imgPetPhoto;
    ProgressBar pbImage;
    ViewPager viewPager;
    ImageSwipeAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_single_view, container, false);

//        imgPetPhoto = (ImageView) v.findViewById(R.id.imgPetPhoto);
//        pbImage = (ProgressBar) v.findViewById(R.id.pbImage);
        viewPager = (ViewPager) v.findViewById(R.id.vpPetImages);
        adapter = new ImageSwipeAdapter(getActivity().getApplicationContext());
        viewPager.setAdapter(adapter);

//        imgPetPhoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getActivity().getApplicationContext(), FullScreenImage.class);
//                imgPetPhoto.buildDrawingCache();
//                Bitmap imgPass = imgPetPhoto.getDrawingCache();
//                Bundle extras = new Bundle();
//                extras.putParcelable("petImage", imgPass);
//                i.putExtras(extras);
//                startActivity(i);
//            }
//        });
//
//        String imgURL = "https://www.pakpets.com/uploads/ad_19393335700762.jpg";
//        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
//                .cacheInMemory(true).cacheOnDisk(true).build();
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity().getApplicationContext())
//                .defaultDisplayImageOptions(defaultOptions).build();
//        ImageLoader.getInstance().init(config); // Do it on Application start
//
//        // Then later, when you want to display image
//        ImageLoader.getInstance().displayImage(imgURL, imgPetPhoto, new ImageLoadingListener() {
//            @Override
//            public void onLoadingStarted(String imageUri, View view) {
//                pbImage.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//                pbImage.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                pbImage.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onLoadingCancelled(String imageUri, View view) {
//                pbImage.setVisibility(View.GONE);
//            }
//        }); // Default options will be used
        return v;
    } // End of onCreateView

}

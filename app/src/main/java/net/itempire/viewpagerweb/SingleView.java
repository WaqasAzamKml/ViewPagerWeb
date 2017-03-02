package net.itempire.viewpagerweb;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class SingleView extends Fragment {

    ImageView imgPetPhoto;
    ProgressBar pbImage;
    ViewPager viewPager;
//    ImageSwipeAdapter adapter;
    ImagesPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_single_view, container, false);

//        imgPetPhoto = (ImageView) v.findViewById(R.id.imgPetPhoto);
//        pbImage = (ProgressBar) v.findViewById(R.id.pbImage);
        viewPager = (ViewPager) v.findViewById(R.id.vpPetImages);
//        adapter = new ImageSwipeAdapter(getActivity().getApplicationContext());
        FragmentManager fragmentManager = getChildFragmentManager();
        // getChildFragmentManager because we are going to use a fragment inside another fragment,
        // so getFragmentManager() or getActivity().getSupportFragmentManager() will return the fragmentManager of Parent Fragment.

        adapter = new ImagesPagerAdapter(fragmentManager,getActivity().getApplicationContext());
        addFragments();
        adapter.notifyDataSetChanged();
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

    private void addFragments(){
        ImageSwipeFragment fragment = new ImageSwipeFragment();
        ImageSwipeFragment fragment2 = new ImageSwipeFragment();
        ImageSwipeFragment fragment3 = new ImageSwipeFragment();
        fragment.setImageNumber(0);
        fragment2.setImageNumber(1);
        fragment3.setImageNumber(2);
        adapter.addFragment(fragment);
        adapter.addFragment(fragment2);
        adapter.addFragment(fragment3);
    }

}

class ImagesPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    Context context;

    /**
     * Creates a new PagerAdapter instance.
     *
     * @param fragmentManager The FragmentManager.
     */
    public ImagesPagerAdapter(FragmentManager fragmentManager, Context ctx) {
        super(fragmentManager);
        this.context = ctx;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
//        if(position == 0){
//            Fragment fragment = fragments.get(fragmentPosition);
//            Toast.makeText(context, tabTitles.get(fragmentPosition), Toast.LENGTH_SHORT).show();
//            fragmentPosition++;
//            return fragment;
//        }
//        else{
//            Fragment fragment = fragments.get(fragmentPosition);
//            Toast.makeText(context, tabTitles.get(fragmentPosition), Toast.LENGTH_SHORT).show();
//            addFragment(new SingleView(),"Fragment"+fragments.size()+1);
//            notifyDataSetChanged();
//            fragmentPosition++;
//            return fragment;
//        }
//        if(position == 0){
//            Toast.makeText(context, tabTitles.get(position), Toast.LENGTH_SHORT).show();
//            return fragments.get(position);
//        }
//        else{
//            Toast.makeText(context, tabTitles.get(position), Toast.LENGTH_SHORT).show();
//            addFragment(new SingleView(),"Fragment"+fragments.size()+1);
//            notifyDataSetChanged();
//            return fragments.get(position);
//        }
        return fragments.get(position);
    }

    /**
     * Adds the fragment to the list, also adds the fragment's tab title.
     *
     * @param fragment New instance of the Fragment to be associated with this tab.
     */
    public void addFragment(Fragment fragment) {
        fragments.add(fragment);
    }

}
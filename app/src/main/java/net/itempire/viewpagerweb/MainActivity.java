package net.itempire.viewpagerweb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager = (ViewPager) findViewById(R.id.vpMain);
        viewPager.setAdapter(new mPagerAdapter(fragmentManager));
    }
}


class mPagerAdapter extends FragmentPagerAdapter{

    public mPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new SingleView();
        }
        if(position == 1){
            return new SingleView();
        }
        if(position == 2){
            return new SingleView();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
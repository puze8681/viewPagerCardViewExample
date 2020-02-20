package kr.puze.customcardview;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class CardFragmentPagerAdapter extends FragmentStatePagerAdapter{
    private List<CardFragment> fragments;
    private List<String> imageList;
    private List<String> titleList;
    public CardFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        imageList = new ArrayList<>();
        titleList = new ArrayList<>();
    }
    @Override
    public int getCount() {
        return fragments.size();
    }
    @Override
    public Fragment getItem(int position) {
        return CardFragment.getInstance(imageList.get(position), titleList.get(position));
    }
    public void addCardFragment(CardFragment fragment, String image, String title) {
        fragments.add(fragment);
        imageList.add(image);
        titleList.add(title);
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        fragments.set(position, (CardFragment) fragment);
        return fragment;
    }
}
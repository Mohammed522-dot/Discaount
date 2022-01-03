package com.example.discaount.views;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.discaount.R;
import com.example.discaount.adapters.TabViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class MedicineFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager firstViewPager;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_medi, container, false);
        firstViewPager = view.findViewById(R.id.viewpager_content);
        tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(firstViewPager);
        setupViewPager(firstViewPager);
        return view;
    }
    private void setupViewPager(ViewPager viewPager) {
        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getChildFragmentManager());
//        adapter.addFragment(new PersonalFragment(), getResources().getString(R.string.person_account));
//        adapter.addFragment(new GroupFragment(), getResources().getString(R.string.group));
//        adapter.addFragment(new RequestFragment(), getResources().getString(R.string.requests));
        viewPager.setAdapter(adapter);
       // Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Hacen-Algeria.ttf");

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    //((TextView) tabViewChild).setTypeface(typeface, Typeface.NORMAL);
                }
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        setupViewPager(firstViewPager);

    }
}


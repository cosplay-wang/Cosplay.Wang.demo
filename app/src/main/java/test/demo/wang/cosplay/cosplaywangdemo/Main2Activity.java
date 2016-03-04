package test.demo.wang.cosplay.cosplaywangdemo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import test.demo.wang.cosplay.cosplaywangdemo.tabBottom.BottomFragment;

public class Main2Activity extends Activity implements View.OnClickListener {
    List<Fragment> fragment_list;
    RadioGroup bottom_RG;
    RadioButton ra1, ra2, ra3;
    FrameLayout fragment_container;
    int fragment_size = 3;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Initview();
        fragment_list = getFragments(fragment_size);
        addFragment(fragment_list, "fragment");
        ra1.setChecked(true);


        //   fragment_ad = new BottomFragmentPagerAdapter(getSupportFragmentManager(),fragment_list,title_list);
//        fragment_viewpager.setAdapter(fragment_ad);
//
//        bottom_tab_layout.setupWithViewPager(fragment_viewpager);
//        //设置TabLayout的模式
//        bottom_tab_layout.setTabMode(TabLayout.MODE_FIXED);
//
//        bottom_tab_layout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private void addFragment(List<Fragment> fragments, String tag) {

        FragmentTransaction transaction;
        manager = getFragmentManager();
        transaction = manager.beginTransaction();

        for (int i = 0; i < fragments.size(); i++) {
            if (!fragments.get(i).isAdded()) {
                transaction.add(R.id.fragment_container, fragments.get(i), tag + i);
                if (i != 0) {
                    transaction.hide(fragments.get(i));
                }

            }

        }
        transaction.commit();

    }

    private void Initview() {
        ra1 = (RadioButton) findViewById(R.id.radio1);
        ra2 = (RadioButton) findViewById(R.id.radio2);
        ra3 = (RadioButton) findViewById(R.id.radio3);
        ra1.setOnClickListener(this);
        ra2.setOnClickListener(this);
        ra3.setOnClickListener(this);
        fragment_container = (FrameLayout) findViewById(R.id.fragment_container);
        bottom_RG = (RadioGroup) findViewById(R.id.bottom_bar);

    }

    private List<Fragment> getFragments(int num) {
        List<Fragment> fragments = new ArrayList<Fragment>();
        for (int i = 0; i < num; i++) {
            BottomFragment frag = new BottomFragment();
            fragments.add(frag);

        }
        return fragments;
    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction;
        manager = getFragmentManager();
        transaction = manager.beginTransaction();


        switch (v.getId()) {
            case R.id.radio1:

                transaction.show(fragment_list.get(0));
                transaction.hide(fragment_list.get(1));
                transaction.hide(fragment_list.get(2));

                break;
            case R.id.radio2:
                transaction.show(fragment_list.get(1));
                transaction.hide(fragment_list.get(0));
                transaction.hide(fragment_list.get(2));
                break;
            case R.id.radio3:
                transaction.show(fragment_list.get(2));
                transaction.hide(fragment_list.get(1));
                transaction.hide(fragment_list.get(0));
                break;

        }
        transaction.commit();
    }
}

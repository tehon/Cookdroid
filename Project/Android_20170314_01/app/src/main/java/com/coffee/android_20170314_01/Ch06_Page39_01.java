package com.coffee.android_20170314_01;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class Ch06_Page39_01 extends AppCompatActivity implements ActionBar.TabListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ch06__page39_01);

    ActionBar bar = getSupportActionBar();

    bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

    // 탭 세개 만들기
    ActionBar.Tab tab01 = bar.newTab();
    tab01.setText("하탭나");
    tab01.setTabListener(this);

    ActionBar.Tab tab02 = bar.newTab();
    tab02.setText("두탭리");
    tab02.setTabListener(this);

    ActionBar.Tab tab03 = bar.newTab();
    tab03.setText("세탭시");
    tab03.setTabListener(this);

    ActionBar.Tab tab04 = bar.newTab();
    tab04.setText("네탭시");
    tab04.setTabListener(this);

    // 합쳐
    bar.addTab(tab01);
    bar.addTab(tab02);
    bar.addTab(tab03);
    bar.addTab(tab04);
  }

  @Override
  public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

  }

  @Override
  public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

  }

  @Override
  public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

  }
}

package com.dipakkr.github.clashhackproject.employer.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dipakkr.github.clashhackproject.R;
import com.dipakkr.github.clashhackproject.employer.fragments.EmployeeSearch;
import com.dipakkr.github.clashhackproject.employer.fragments.EmployerSetting;

/**
 * Created by deepak on 26-03-2017.
 */

public class MyPagerAdapter  extends FragmentPagerAdapter{

    private Context mContext;
    public MyPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0 ){
            return mContext.getResources().getString(R.string.frag_job_search);
        }
        else{
            return mContext.getResources().getString(R.string.frag_setting);  }
    }
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return  new EmployeeSearch();
        }else if(position==1){
            return new EmployerSetting();
        }
        else
            return new EmployeeSearch();
    }
}

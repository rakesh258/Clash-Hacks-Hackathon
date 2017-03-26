package com.dipakkr.github.clashhackproject.Employee.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dipakkr.github.clashhackproject.Employee.fragment.JobSearch;
import com.dipakkr.github.clashhackproject.Employee.fragment.JobSuggestions;
import com.dipakkr.github.clashhackproject.R;

/**
 * Created by deepak on 26-03-2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    public ViewPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if(position ==0){
            return mContext.getResources().getString(R.string.frag_job_search);
        }
        else if (position == 1 ){
            return mContext.getResources().getString(R.string.frag_job_suggestion);
        }
        return super.getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new JobSearch();
        }
        else
            return new JobSuggestions();
    }

    @Override
    public int getCount() {
        return 2;
    }


}

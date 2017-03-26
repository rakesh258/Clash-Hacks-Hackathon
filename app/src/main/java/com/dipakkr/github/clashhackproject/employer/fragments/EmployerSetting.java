package com.dipakkr.github.clashhackproject.employer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dipakkr.github.clashhackproject.R;

/**
 * Created by deepak on 26-03-2017.
 */

public class EmployerSetting extends Fragment {

    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.employer_setting,container,false);
        return view;
    }
}

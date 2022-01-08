package com.example.lab2_mob201.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab2_mob201.BroadCast.BroadCastReceiverBai1;
import com.example.lab2_mob201.R;


public class Fragment_Bai1 extends Fragment {


    public Fragment_Bai1() {
        // Required empty public constructor
    }

    public static Fragment_Bai1 newInstance() {
        Fragment_Bai1 fragment = new Fragment_Bai1();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bai1, container, false);
        this.Quyen();
        Intent intent = new Intent(getActivity(), BroadCastReceiverBai1.class);
        requireActivity().sendBroadcast(intent);
        return view;
    }

    private boolean Quyen() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED
                    && ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_PHONE_NUMBERS) == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_PHONE_NUMBERS}, 1);
                return false;
            }
        } else {
            Log.d("QUYEN", "True");
            return true;
        }
    }
}
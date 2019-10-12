package com.example.myapplication2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SecondFragment extends Fragment {
    private static final String EXTRA_PARAM = "some_param";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String text = "no value supplied";
        Bundle arguments = getArguments();
        if (arguments != null) {
            text = arguments.getString(EXTRA_PARAM);
        }
        ((TextView)view.findViewById(R.id.quq)).setText(text);
        if (Integer.parseInt(text) % 2 == 0)
                ((TextView)view.findViewById(R.id.quq)).setTextColor(Color.RED);
              else
                ((TextView)view.findViewById(R.id.quq)).setTextColor(Color.BLUE);

        }


    public static SecondFragment newInstance(int param) {
        SecondFragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_PARAM, String.valueOf(param));
        fragment.setArguments(bundle);
        return fragment;
    }
}

package com.example.myapplication2;

import android.content.res.ColorStateList;
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
    private static final String EXTRA_COLOR = "some_color";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String text = "no value supplied";
        int color = 1;
        Bundle arguments = getArguments();
        if (arguments != null) {
            text = arguments.getString(EXTRA_PARAM);
            color = arguments.getInt(EXTRA_COLOR);
        }
        ((TextView)view.findViewById(R.id.quq)).setText(text);
        /*if (Integer.parseInt(text) % 2 == 0)
                ((TextView)view.findViewById(R.id.quq)).setTextColor(Color.RED);
              else
                ((TextView)view.findViewById(R.id.quq)).setTextColor(Color.BLUE);*/
        ((TextView)view.findViewById(R.id.quq)).setTextColor(color);

        }


    public static SecondFragment newInstance(int param, int color) {
        SecondFragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_PARAM, String.valueOf(param));
        bundle.putInt(EXTRA_COLOR, color);
        fragment.setArguments(bundle);
        return fragment;
    }
}

package com.example.myapplication2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import java.util.List;


public class ListFragment extends Fragment {

    private MyDataAdapter mAdapter;
    int DEFAULT_SIZE = 100;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        int mColumnCount = getResources().getBoolean(R.bool.is_horizontal) ?
                  4 : 3;
        Context context = view.getContext();
        if (view.findViewById(R.id.gridView) instanceof RecyclerView) {
            RecyclerView recyclerView = view.findViewById(R.id.gridView);
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            mAdapter = new MyDataAdapter(DataSource.getInstance().getData());
            recyclerView.setAdapter(mAdapter);
        }
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSource.push();
                mAdapter.notifyItemInserted(++DEFAULT_SIZE);
            }
        });
        return view;
    }


    class MyDataAdapter extends RecyclerView.Adapter<MyViewHolder> {

        final int TYPE_FIRST = 1;
        final int TYPE_SECOND = 2;
        List<DataSource.MyData> mData;

        public MyDataAdapter(List<DataSource.MyData> data) {
            mData = data;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d("ListActivity", "onCreateViewHolder " + viewType);
            View view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.fragment_list_item, parent, false);
            TextView textView = view.findViewById(R.id.item);
            switch (viewType) {
                case TYPE_FIRST:
                    textView.setTextColor(Color.RED);
                    break;
                case TYPE_SECOND:
                    textView.setTextColor(Color.BLUE);
                    break;
                default:
                    throw new IllegalStateException();
            }
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            DataSource.MyData data = mData.get(position);
            holder.mTitle.setText(data.mTitle);

            Log.d("ListActivity", "onBindViewHolder " + position);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        @Override
        public int getItemViewType(int position) {
            return (position % 2 == 0) ? TYPE_SECOND : TYPE_FIRST;
        }

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle;


        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.item);
            mTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = MyViewHolder.this.getAdapterPosition();
                    DataSource.MyData myData = mAdapter.mData.get(pos);
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.top_container,  SecondFragment.newInstance(Integer.parseInt(myData.mTitle), mTitle.getCurrentTextColor()))
                            .addToBackStack(null)
                            .commit();

                }
            });
    }
    }
}

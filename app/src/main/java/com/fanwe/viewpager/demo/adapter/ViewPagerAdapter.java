package com.fanwe.viewpager.demo.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.fanwe.lib.selectmanager.SDSelectManager;
import com.fanwe.library.adapter.SDPagerAdapter;
import com.fanwe.viewpager.demo.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/9.
 */

public class ViewPagerAdapter extends SDPagerAdapter<SDSelectManager.SelectableModel>
{
    public ViewPagerAdapter(List<SDSelectManager.SelectableModel> listModel, Activity activity)
    {
        super(listModel, activity);
    }

    @Override
    public View getView(ViewGroup container, int position)
    {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_viewpager, container, false);
        TextView button = (TextView) view.findViewById(R.id.btn);
        button.setText(String.valueOf(position));
        return view;
    }
}

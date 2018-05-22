package com.fanwe.viewpager.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.fanwe.lib.utils.FIterateUtil;
import com.fanwe.lib.viewpager.SDGridViewPager;
import com.fanwe.lib.viewpager.indicator.IPagerIndicatorItem;
import com.fanwe.lib.viewpager.indicator.adapter.PagerIndicatorAdapter;
import com.fanwe.lib.viewpager.indicator.impl.PagerIndicator;
import com.fanwe.library.utils.LogUtil;
import com.fanwe.viewpager.demo.adapter.ItemAdapter;
import com.fanwe.viewpager.demo.model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class ScrollActivity extends AppCompatActivity
{
    private SDGridViewPager mViewPager;
    private PagerIndicator mPagerIndicator;

    private List<DataModel> mListModel = new ArrayList<>();
    private ItemAdapter mItemAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_scroll);
        initAdapter();

        mViewPager = (SDGridViewPager) findViewById(R.id.vpg_content);
        mPagerIndicator = (PagerIndicator) findViewById(R.id.view_pager_indicator);

        mPagerIndicator.setDebug(true);
        mPagerIndicator.setAdapter(new PagerIndicatorAdapter()
        {
            @Override
            public IPagerIndicatorItem onCreatePagerIndicatorItem(final int position, ViewGroup viewParent)
            {
                LogUtil.i("onCreatePagerIndicatorItem:" + position);
                CustomPagerIndicatorItem item = new CustomPagerIndicatorItem(viewParent.getContext());
                item.getTextView().setText(mListModel.get(position).getName());
                return item;
            }
        });
        mPagerIndicator.setViewPager(mViewPager); //给指示器设置ViewPager

        //设置ViewPager参数
        mViewPager.setGridItemCountPerPage(1); //设置每页有几个数据
        mViewPager.setGridColumnCountPerPage(1); //设置每一页有几列
        mViewPager.setGridHorizontalDivider(getResources().getDrawable(R.drawable.divider_horizontal)); //设置横分割线
        mViewPager.setGridVerticalDivider(getResources().getDrawable(R.drawable.divider_vertical)); //设置竖分割线
        mViewPager.setGridAdapter(mItemAdapter); //设置适配器
    }

    private void initAdapter()
    {
        FIterateUtil.foreach(5, new FIterateUtil.SimpleIterateCallback()
        {
            @Override
            public boolean next(int i)
            {
                DataModel model = new DataModel();
                model.setName(String.valueOf(i));
                mListModel.add(model);
                return false;
            }
        });
        mItemAdapter = new ItemAdapter(mListModel, this);
    }

    public void onClickBtnTest(View v)
    {
        mListModel.get(0).setName("hello");
        mPagerIndicator.getAdapter().notifyDataSetChanged();
    }

}

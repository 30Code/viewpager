package com.fanwe.viewpager.demo.model;


import com.fanwe.lib.selectmanager.SDSelectManager;

/**
 * Created by Administrator on 2017/8/25.
 */

public class DataModel extends SDSelectManager.SelectableModel
{

    private String name;


    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}

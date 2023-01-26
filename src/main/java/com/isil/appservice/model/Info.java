package com.isil.appservice.model;

import java.util.ArrayList;

public class Info {
    public ArrayList<Info> info;
    public int count;
    public int pages;
   public String next;

    @Override
    public String toString() {
        return  "count: "+count + "\npages:"+pages+"\nnext:"+next;
    }
}

package com.example.utils;


import java.util.List;

public class Returnobj<T> {
    String name;
    List<T> lists;

    public Returnobj(){
        name = "";
        lists = null;
    }


    public Returnobj(String name , List<T> tList){
        name = "";
        lists = tList;
    }


    public void setName(String name){
        this.name = name;
    }


    public void setList(List<T> tList){
        this.lists = tList;
    }

    public String getName(){
        return this.name;
    }

    public List<T> getList(){
        return this.lists;
    }


}

package com.minhasoft1.adddatatospinner;

import androidx.annotation.NonNull;

import com.orm.SugarRecord;

public class SpinnerCategory extends SugarRecord {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
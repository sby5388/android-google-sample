package com.android.example.bindingdemo.vo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Color;

import com.android.example.bindingdemo.BR;

public class User extends BaseObservable {
    @Bindable
    private String name;
    @Bindable
    private String lastName;
    @Bindable
    private int photoResource = 0;
    @Bindable
    private int favoriteColor = Color.RED;
    @Bindable
    private int group;
    public static final int KITTEN = 1;
    public static final int ROBOT = 2;

    public User(String name, String lastName, int photoResource, int group) {
        this.name = name;
        this.lastName = lastName;
        this.photoResource = photoResource;
        this.group = group;
    }

    public void setGroup(int group) {
        if (this.group == group) {
            return;
        }
        this.group = group;
        notifyPropertyChanged(BR.group);
    }

    public int getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.name != null && this.name.equals(name)) {
            return;
        }
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (this.lastName != null && this.lastName.equals(lastName)) {
            return;
        }
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    public int getPhotoResource() {
        return photoResource;
    }

    public void setPhotoResource(int photoResource) {
        if (this.photoResource == photoResource) {
            return;
        }
        this.photoResource = photoResource;
        notifyPropertyChanged(BR.photoResource);
    }

    public int getFavoriteColor() {
        return favoriteColor;
    }
}

package com.example.ali.myapp;

import java.util.List;

public class CategoryModel {
    private String catName;
    private int photoId;
    public List<CategoryModel>categoryList;

    public String getCatName() {
        return this.catName;
    }

    public int getPhotoId() {
        return this.photoId;
    }

    public CategoryModel(String catName, int photoId) {
        this.catName = catName;
        this.photoId = photoId;
    }
    public CategoryModel(){}
}

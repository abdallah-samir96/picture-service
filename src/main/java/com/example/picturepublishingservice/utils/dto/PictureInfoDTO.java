package com.example.picturepublishingservice.utils.dto;

import com.example.picturepublishingservice.utils.enums.PictureCategory;

public class PictureInfoDTO {
    public String description;
    public PictureCategory category;

    public long size;
    public String name;

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PictureCategory getCategory() {
        return category;
    }

    public void setCategory(PictureCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "PictureInfoDTO{" +
                "description='" + description + '\'' +
                ", category=" + category +
                ", size=" + size +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.example.picturepublishingservice.model;

import com.example.picturepublishingservice.utils.enums.PictureCategory;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "picture")
public class Picture extends SharedFields implements Serializable {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "size", nullable = false)
    private long size;

    @Column(name = "is_accepted")
    private Boolean accepted;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private PictureCategory category;

    @Column(name = "description")
    private String description;

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void setCategory(PictureCategory category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public PictureCategory getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
}

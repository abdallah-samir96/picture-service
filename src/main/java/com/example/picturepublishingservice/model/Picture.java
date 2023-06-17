package com.example.picturepublishingservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "picture")
public class Picture extends SharedFields implements Serializable {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "size", nullable = false)
    private long size;

    @Column(name = "is_accepted", nullable = true)
    private boolean accepted;


}

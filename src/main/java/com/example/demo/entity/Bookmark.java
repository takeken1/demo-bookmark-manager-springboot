package com.example.demo.entity;

import lombok.Data;

@Data
public class Bookmark {
    private Long id;
    private String url;
    private String title;
    private String description;
}

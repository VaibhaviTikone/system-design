package com.example.urlshortner.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "url_mapping")
public class UrlMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true, length = 2048)
    private String longUrl;
    @Column(unique = true)
    private String shortCode;
}

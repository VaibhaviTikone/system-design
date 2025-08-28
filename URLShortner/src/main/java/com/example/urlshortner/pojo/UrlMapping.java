package com.example.urlshortner.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "url_mapping")
public class UrlMapping {
    @Id
    @SequenceGenerator(name = "appSeq", sequenceName = "app_seq", initialValue = 1000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "appSeq")
    private long id;
    @Column(nullable = false, unique = true, length = 2048)
    private String longUrl;
    @Column(unique = true)
    private String shortCode;
}

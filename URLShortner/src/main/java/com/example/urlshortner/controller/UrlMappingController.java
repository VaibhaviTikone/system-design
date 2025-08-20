package com.example.urlshortner.controller;

import com.example.urlshortner.dto.UrlMappingDTO;
import com.example.urlshortner.pojo.UrlMapping;
import com.example.urlshortner.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shortUrl")
public class UrlMappingController {

    private final UrlService urlService;

    public UrlMappingController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping({"/{shortCode}", "/../{shortCode}"})
    public ResponseEntity<?> getShortUrl(@PathVariable String shortCode) {
        return urlService.getLongUrl(shortCode).map(longUrl ->  ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", longUrl).build())
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody UrlMappingDTO dto) {
        return urlService.shortenUrl(dto.longUrl());
    }
}

package com.example.urlshortner.service;

import java.util.Optional;

public interface UrlService {
    String shortenUrl(String url);
    Optional<String> getLongUrl(String shortCode);
}

package com.example.urlshortner.utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UrlShortnerUtility {
    private final static String BASE62 = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public static String encode(long id) {
        StringBuilder sb = new StringBuilder();
        while(id>0) {
            sb.append(BASE62.charAt((int)(id%62)));
            id/=62;
        }
        log.info("code: {}", sb);
        return sb.reverse().toString();
    }
}

package com.example.urlshortner.service;

import com.example.urlshortner.pojo.UrlMapping;
import com.example.urlshortner.repository.UrlMappingRepository;
import com.example.urlshortner.utility.UrlShortnerUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UrlServiceImpl implements UrlService {

    private final UrlMappingRepository repository;

    public UrlServiceImpl(UrlMappingRepository repository) {
        this.repository = repository;
    }

    @Override
    public String shortenUrl(String url) {
        UrlMapping mapping = new UrlMapping();
        mapping.setLongUrl(url);
        mapping = repository.save(mapping);
        mapping.setShortCode(UrlShortnerUtility.encode(mapping.getId()));
        repository.save(mapping);
        return "http://localhost:8080/api/shortUrl" + mapping.getShortCode();
    }



    @Override
    public Optional<String> getLongUrl(String shortCode) {
        Optional<String> res = repository.findByShortCode(shortCode).map(UrlMapping::getLongUrl);
        log.info("res: {}", res.orElse(""));
        return res;
    }
}

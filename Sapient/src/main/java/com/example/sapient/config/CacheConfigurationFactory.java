package com.example.sapient.config;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sapient.cache.CacheService;

@Component
public class CacheConfigurationFactory {
    @Autowired(required = true)
	List<CacheService> cacheServices;
    
   private Map<String,CacheService> cacheServicesByName;
    
    @PostConstruct
    public void init() {
    	cacheServicesByName=cacheServices.stream().collect(Collectors.toMap(CacheService::getName, v->v));
    }
    
    public CacheService getBy(String name) {
    	return cacheServicesByName.get(name);
    }
}

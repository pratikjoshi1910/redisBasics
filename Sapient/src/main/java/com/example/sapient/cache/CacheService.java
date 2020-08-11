package com.example.sapient.cache;

import java.util.Map;

public interface CacheService {

	boolean createCache(Map map);

	Boolean getCacheDetails();

	String getName();

	Map getCacheDate();

}

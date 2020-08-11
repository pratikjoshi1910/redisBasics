package com.example.sapient.cache;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.sapient.cache.commons.LocalCache;

@Service
public class LocalCacheService implements CacheService {
	
	@Autowired
	LocalCache localCache;

	@Override
	public Boolean getCacheDetails() {
		return null;
	}



	@Override
	public boolean createCache(Map map) {
		// TODO Auto-generated method stub
		 localCache.mapUpdate(map);
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "local";
	}



	@Override
	public Map getCacheDate() {
		// TODO Auto-generated method stub
		return localCache.getCacheData();
	}

}

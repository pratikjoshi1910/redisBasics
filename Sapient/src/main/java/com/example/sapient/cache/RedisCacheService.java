package com.example.sapient.cache;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class RedisCacheService implements CacheService{

	

	@Override
	public Boolean getCacheDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createCache(Map map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Redis";
	}

	@Override
	public Map getCacheDate() {
		// TODO Auto-generated method stub
		return null;
	}

}

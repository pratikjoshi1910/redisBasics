package com.example.sapient.cache.commons;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public final class LocalCache {

	private volatile Map locaCache;

	public void mapUpdate(Map map) {
		Map<?, ?> newCache = new HashMap<>(map);
		locaCache = Collections.unmodifiableMap(newCache);
	}

	public boolean isEmpty() {
		return locaCache.isEmpty();
	}

	public Map getCacheData() {
		return locaCache;
	}
}

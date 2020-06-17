package com.donatasd.favoriteartist.cache;

import java.util.Objects;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

/**
 * Provides control on cache
 *
 * @author Donatas Daubaras
 */
@Service
public class CacheService {

  private final CacheManager cacheManager;

  public CacheService(CacheManager cacheManager) {
    this.cacheManager = cacheManager;
  }

  public void clearAllCaches() {
    cacheManager.getCacheNames().forEach(name ->
        Objects.requireNonNull(cacheManager.getCache(name)).clear()
    );
  }


}

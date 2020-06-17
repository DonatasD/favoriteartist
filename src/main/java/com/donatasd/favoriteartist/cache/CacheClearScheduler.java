package com.donatasd.favoriteartist.cache;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Schedules cache clearing.
 *
 * @author Donatas Daubaras
 */
@Component
public class CacheClearScheduler {

  private CacheService cacheService;

  private final static Integer CACHE_CLEAR_TIME_MS = 1000 * 60 * 60 * 24;

  public CacheClearScheduler(CacheService cacheService) {
    this.cacheService = cacheService;
  }

  /**
   * Schedule daily cache clearing
   */
  @Scheduled(fixedDelay = CACHE_CLEAR_TIME_MS)
  public void scheduleAllCacheEviction() {
    cacheService.clearAllCaches();
  }

}

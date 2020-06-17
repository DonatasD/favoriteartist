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

  public CacheClearScheduler(CacheService cacheService) {
    this.cacheService = cacheService;
  }

  /**
   * Schedule daily cache clearing
   */
  @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
  public void scheduleAllCacheEviction() {
    cacheService.clearAllCaches();
  }

}

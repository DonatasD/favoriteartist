package com.donatasd.favoriteartist.api.album;

import com.donatasd.favoriteartist.integration.itunes.ItunesClient;
import com.donatasd.favoriteartist.integration.itunes.domain.Response;
import com.donatasd.favoriteartist.integration.itunes.domain.WrapperType;
import com.donatasd.favoriteartist.integration.itunes.domain.collection.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Donatas Daubaras
 */
@Service
@Slf4j
public class AlbumService {

  private final ItunesClient itunesClient;

  public AlbumService(ItunesClient itunesClient) {
    this.itunesClient = itunesClient;
  }

  @Cacheable(value = "topAlbums")
  public List<Collection> findTopAlbums(Long amgArtistId, Integer limit) {
    var collections = itunesClient.findAlbums(amgArtistId, limit)
            .map(Response::getResults)
            .orElse(List.of());
    var result = collections.stream()
        .filter(collection -> collection.getWrapperType().equals(WrapperType.collection))
        .collect(Collectors.toList());
    log.debug("Found {} collections", result.size());
    return result;
  }
}

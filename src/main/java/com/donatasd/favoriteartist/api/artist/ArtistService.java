package com.donatasd.favoriteartist.api.artist;

import com.donatasd.favoriteartist.integration.itunes.ItunesClient;
import com.donatasd.favoriteartist.integration.itunes.domain.WrapperType;
import com.donatasd.favoriteartist.integration.itunes.domain.artist.Artist;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Donatas Daubaras
 */
@Slf4j
@Service
public class ArtistService {

  private final ItunesClient itunesClient;

  public ArtistService(ItunesClient itunesClient) {
    this.itunesClient = itunesClient;
  }

  @Cacheable(value = "artists")
  public List<Artist> findAllByTerm(String term) {
    var result = itunesClient.findArtists(term)
        .stream()
        .filter(artist -> Objects.nonNull(artist.getAmgArtistId()))
        .filter(artist -> artist.getWrapperType().equals(WrapperType.artist))
        .collect(Collectors.toList());
    log.debug("Found {} artists", result.size());
    return result;
  }
}

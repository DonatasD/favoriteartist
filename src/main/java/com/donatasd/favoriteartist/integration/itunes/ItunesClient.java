package com.donatasd.favoriteartist.integration.itunes;

import com.donatasd.favoriteartist.integration.itunes.domain.Response;
import com.donatasd.favoriteartist.integration.itunes.domain.artist.Artist;
import com.donatasd.favoriteartist.integration.itunes.domain.artist.ArtistResponseWrapper;
import com.donatasd.favoriteartist.integration.itunes.domain.collection.Collection;
import com.donatasd.favoriteartist.integration.itunes.domain.collection.CollectionResponseWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Donatas Daubaras
 */
@Component
@Slf4j
public class ItunesClient {

  private final RestTemplate restTemplate;

  private final ObjectMapper objectMapper;

  private static final String HOST = "https://itunes.apple.com";

  public ItunesClient(
      RestTemplate restTemplate,
      ObjectMapper objectMapper
  ) {
    this.restTemplate = restTemplate;
    this.objectMapper = objectMapper;
  }

  public Optional<Response<Artist>> findArtists(@NonNull String term) {
    var url = String.format(
        "%s/search?entity=allArtist&term=%s",
        HOST,
        term
    );
    log.debug("Searching for artist with url {}", url);
    try {
      var response = restTemplate.getForEntity(url, String.class);
      var result = objectMapper.readValue(response.getBody(), ArtistResponseWrapper.class);
      return Optional.ofNullable(result);
    } catch (Exception e) {
      log.error("Failed to get result for artist search", e);
    }
    return Optional.empty();
  }

  public Optional<Response<Collection>> findAlbums(
      @NonNull String amgArtistId,
      @NonNull Integer limit
  ) {
    var url = String.format(
        "%s/lookup?amgArtistId=%s&entity=album&limit=%s",
        HOST,
        amgArtistId,
        limit
    );
    log.debug("Searching for albums with url {}", url);
    try {
      var response = restTemplate.getForEntity(url, String.class);
      var result = objectMapper.readValue(response.getBody(), CollectionResponseWrapper.class);
      return Optional.of(result);
    } catch (Exception e) {
      log.error("Failed to get result for artist search", e);
    }
    return Optional.empty();
  }

  public Optional<Response<Collection>> findAlbums(@NonNull String amgArtistId) {
    return findAlbums(amgArtistId, 5);
  }

}

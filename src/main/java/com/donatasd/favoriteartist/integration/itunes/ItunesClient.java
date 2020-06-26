package com.donatasd.favoriteartist.integration.itunes;

import com.donatasd.favoriteartist.integration.itunes.domain.artist.Artist;
import com.donatasd.favoriteartist.integration.itunes.domain.artist.ArtistResponseWrapper;
import com.donatasd.favoriteartist.integration.itunes.domain.collection.Collection;
import com.donatasd.favoriteartist.integration.itunes.domain.collection.CollectionResponseWrapper;
import com.donatasd.favoriteartist.integration.itunes.exception.ITunesClientException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
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

  public List<Artist> findArtists(@NonNull String term) {
    var url = String.format(
        "%s/search?entity=allArtist&term=%s",
        HOST,
        term
    );
    log.debug("Searching for artist with url {}", url);
    try {
      var response = restTemplate.getForEntity(url, String.class);
      var result = objectMapper.readValue(response.getBody(), ArtistResponseWrapper.class);
      return result.getResults();
    } catch (Exception e) {
      log.error("Failed to get result for artist search", e);
      throw new ITunesClientException("Failed to get result for artist search");
    }
  }

  public List<Collection> findAlbums(
      @NonNull Long amgArtistId,
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
      return result.getResults();
    } catch (Exception e) {
      log.error("Failed to get result for artist search", e);
      throw new ITunesClientException("Failed to get result for artist search");
    }
  }
}

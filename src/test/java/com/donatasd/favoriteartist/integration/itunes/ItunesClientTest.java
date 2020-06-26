package com.donatasd.favoriteartist.integration.itunes;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Integration test {@link ItunesClient}
 *
 * @author Donatas Daubaras
 */
@SpringBootTest
public class ItunesClientTest {

  @Autowired
  private ItunesClient itunesClient;

  @Test
  void findArtists() {
    var result = itunesClient.findArtists("abba");
    assertFalse(result.isEmpty());
  }

  @Test
  void findAlbums() {
    var result = itunesClient.findAlbums(3492L, 5);
    assertFalse(result.isEmpty());
  }


}

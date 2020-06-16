package com.donatasd.favoriteartist.integration.itunes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Donatas Daubaras
 */
@SpringBootTest
class ItunesClientTest {

  @Autowired
  private ItunesClient itunesClient;

  @Test
  void successfullySearchesForArtists() {
    var result = itunesClient.findArtists("abba");
    assertTrue(result.isPresent());
  }

  @Test
  void successfullyFindTop5Albums() {
    var result = itunesClient.findAlbums("3492", 5);
    assertTrue(result.isPresent());
  }


}

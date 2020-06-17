package com.donatasd.favoriteartist.api.album;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.donatasd.favoriteartist.integration.itunes.domain.collection.Collection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

/**
 * Integration test for {@link AlbumRestController}
 *
 * @author Donatas Daubaras
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AlbumRestControllerTest {

  private static final Long AMG_ARTIST_ID = 3495L;

  private static final String HOST = "http://localhost";

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void findAllByTerm() {
    var url = String.format("%s:%s/api/albums?amgArtistId=%s", HOST, port, AMG_ARTIST_ID);
    var result = this.restTemplate.getForEntity(url, Collection[].class);
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    assertNotNull(result.getBody());
    assertTrue(result.getBody().length <= 5);
  }
}

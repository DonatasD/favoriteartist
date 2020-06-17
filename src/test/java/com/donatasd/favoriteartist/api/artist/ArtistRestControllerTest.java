package com.donatasd.favoriteartist.api.artist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.donatasd.favoriteartist.integration.itunes.domain.artist.Artist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

/**
 * @author Donatas Daubaras
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ArtistRestControllerTest {

  private static final String SEARCH_TERM = "abba";

  private static final String HOST = "http://localhost";

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void findAllByTerm() {
    var url = String.format("%s:%s/api/artists?term=%s", HOST, port, SEARCH_TERM);
    var result = this.restTemplate.getForEntity(url, Artist[].class);
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    assertNotNull(result.getBody());
  }
}

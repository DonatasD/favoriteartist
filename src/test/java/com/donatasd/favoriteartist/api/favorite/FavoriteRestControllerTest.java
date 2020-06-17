package com.donatasd.favoriteartist.api.favorite;

import static org.junit.jupiter.api.Assertions.*;

import com.donatasd.favoriteartist.api.favorite.dto.CreateFavoriteDTO;
import com.donatasd.favoriteartist.api.favorite.service.FavoriteDTO;
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
public class FavoriteRestControllerTest {

  private static final String HOST = "http://localhost";

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void createFavorite() {
    var url = String.format("%s:%s/api/favorites", HOST, port);
    var requestBody = createFavoriteDTO();
    var result = this.restTemplate.postForEntity(url, requestBody, FavoriteDTO.class);
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    assertNotNull(result.getBody());
    assertNotNull(result.getBody().getId());
  }

  private CreateFavoriteDTO createFavoriteDTO() {
    var createDTO = new CreateFavoriteDTO();
    createDTO.setUserId(2L);
    createDTO.setAmgArtistId(3492L);
    return createDTO;
  }
}

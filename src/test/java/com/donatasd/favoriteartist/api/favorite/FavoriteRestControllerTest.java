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

  private static final Long USER_ID = 1L;

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

  @Test
  public void findAll() {
    var url = String.format("%s:%s/api/favorites?userId=%s", HOST, port, USER_ID);
    var result = this.restTemplate.getForEntity(url, FavoriteDTO[].class);
    assertEquals(result.getStatusCode(), HttpStatus.OK);
    assertNotNull(result.getBody());
    assertTrue(result.getBody().length > 0);
  }

  private CreateFavoriteDTO createFavoriteDTO() {
    return new CreateFavoriteDTO(2L, 3492L);
  }
}

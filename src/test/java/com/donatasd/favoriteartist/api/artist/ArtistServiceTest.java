package com.donatasd.favoriteartist.api.artist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.donatasd.favoriteartist.integration.itunes.ItunesClient;
import com.donatasd.favoriteartist.integration.itunes.domain.WrapperType;
import com.donatasd.favoriteartist.integration.itunes.domain.artist.Artist;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit Test {@link ArtistService}
 *
 * @author Donatas Daubaras
 */
@RunWith(SpringRunner.class)
public class ArtistServiceTest {

  @MockBean
  private ItunesClient itunesClient;

  private ArtistService artistService;

  private static final String SEARCH_TERM = "abba";

  @Before
  public void setUp() {
    this.artistService = new ArtistService(itunesClient);
    Mockito.when(itunesClient.findArtists(SEARCH_TERM)).thenReturn(createArtistsMock());
  }

  @Test
  public void findAllByTerm() {
    var result = artistService.findAllByTerm(SEARCH_TERM);
    assertEquals(1, result.size());
  }

  private List<Artist> createArtistsMock() {
    var artist = new Artist();
    artist.setWrapperType(WrapperType.artist);
    artist.setAmgArtistId(1L);
    return List.of(artist);
  }
}

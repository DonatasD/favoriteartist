package com.donatasd.favoriteartist.api.album;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.donatasd.favoriteartist.integration.itunes.ItunesClient;
import com.donatasd.favoriteartist.integration.itunes.domain.Response;
import com.donatasd.favoriteartist.integration.itunes.domain.WrapperType;
import com.donatasd.favoriteartist.integration.itunes.domain.collection.Collection;
import com.donatasd.favoriteartist.integration.itunes.domain.collection.CollectionResponseWrapper;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit Test {@link AlbumService}
 *
 * @author Donatas Daubaras
 */
@RunWith(SpringRunner.class)
public class AlbumServiceTest {

  @MockBean
  private ItunesClient itunesClient;

  private AlbumService albumService;

  private static final Integer LIMIT = 5;

  private static final Long AMG_ARTIST_ID = 3495L;

  @Before
  public void setUp() {
    this.albumService = new AlbumService(itunesClient);
    Mockito.when(itunesClient.findAlbums(AMG_ARTIST_ID, LIMIT))
        .thenReturn(createCollectionResponse());
  }

  @Test
  public void findTopAlbums() {
    var result = albumService.findTopAlbums(AMG_ARTIST_ID, LIMIT);
    assertEquals(LIMIT, result.size());
  }


  private Optional<Response<Collection>> createCollectionResponse() {
    var response = new CollectionResponseWrapper();
    response.setResultCount(Long.valueOf(LIMIT));
    var collections = IntStream.range(0, LIMIT + 1)
        .mapToObj(i -> {
          /*
           * Mimic itunes api by generating artist entry as well. Allows testing filtering artist
           * entity
           */
          if (i > 0) {
            var collection = new Collection();
            collection.setWrapperType(WrapperType.collection);
            return collection;
          }
          var artist = new Collection();
          artist.setWrapperType(WrapperType.artist);
          return artist;
        })
        .collect(Collectors.toList());
    response.setResults(collections);
    return Optional.of(response);
  }
}

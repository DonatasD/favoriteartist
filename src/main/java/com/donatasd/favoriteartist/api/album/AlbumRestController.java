package com.donatasd.favoriteartist.api.album;

import com.donatasd.favoriteartist.integration.itunes.domain.collection.Collection;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController for albums
 *
 * @author Donatas Daubaras
 */
@RestController
@RequestMapping("api/albums")
public class AlbumRestController {

  private final AlbumService albumService;

  public AlbumRestController(AlbumService albumService) {
    this.albumService = albumService;
  }

  @GetMapping
  public List<Collection> findTopAlbums(
      @RequestParam Long amgArtistId,
      @RequestParam(defaultValue = "5", required = false) Integer limit
  ) {
    return albumService.findTopAlbums(amgArtistId, limit);
  }
}

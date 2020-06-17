package com.donatasd.favoriteartist.api.artist;

import com.donatasd.favoriteartist.integration.itunes.domain.artist.Artist;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController for artists
 *
 * @author Donatas Daubaras
 */
@RestController()
@RequestMapping("/api/artists")
public class ArtistRestController {

  private final ArtistService artistService;

  public ArtistRestController(ArtistService artistService) {
    this.artistService = artistService;
  }

  @GetMapping()
  public List<Artist> findAllByTerm(@RequestParam String term) {
    return artistService.findAllByTerm(term);
  }

}

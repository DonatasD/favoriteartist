package com.donatasd.favoriteartist.api.favorite;

import com.donatasd.favoriteartist.api.favorite.dto.CreateFavoriteDTO;
import com.donatasd.favoriteartist.api.favorite.service.FavoriteDTO;
import com.donatasd.favoriteartist.api.favorite.service.FavoriteService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController for favorite artists
 *
 * @author Donatas Daubaras
 */
@RestController
@RequestMapping("/api/favorites")
public class FavoriteRestController {

  private final FavoriteService favoriteService;

  public FavoriteRestController(FavoriteService favoriteService) {
    this.favoriteService = favoriteService;
  }

  @PostMapping
  public FavoriteDTO createFavorite(@RequestBody CreateFavoriteDTO createDTO) {
    return favoriteService.createFavorite(createDTO);
  }

  @GetMapping
  public List<FavoriteDTO> findAllByUserId(@RequestParam Long userId) {
    return favoriteService.findAllByUserId(userId);
  }

}

package com.donatasd.favoriteartist.api.favorite;

import com.donatasd.favoriteartist.api.favorite.dto.CreateFavoriteDTO;
import com.donatasd.favoriteartist.api.favorite.service.FavoriteDTO;
import com.donatasd.favoriteartist.api.favorite.service.FavoriteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
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

}

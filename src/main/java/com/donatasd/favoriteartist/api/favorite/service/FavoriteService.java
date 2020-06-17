package com.donatasd.favoriteartist.api.favorite.service;

import com.donatasd.favoriteartist.api.favorite.dto.CreateFavoriteDTO;
import com.donatasd.favoriteartist.api.favorite.mapper.FavoriteMapper;
import com.donatasd.favoriteartist.api.favorite.repository.FavoriteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Donatas Daubaras
 */
@Service
@Slf4j
public class FavoriteService {

  private final FavoriteRepository favoriteRepository;

  private final FavoriteMapper favoriteMapper;

  public FavoriteService(
      FavoriteRepository favoriteRepository,
      FavoriteMapper favoriteMapper
  ) {
    this.favoriteRepository = favoriteRepository;
    this.favoriteMapper = favoriteMapper;
  }

  public FavoriteDTO createFavorite(CreateFavoriteDTO createDTO) {
    log.debug("Saving {}", createDTO);
    var entity = favoriteMapper.toFavorite(createDTO);
    var createdEntity = favoriteRepository.save(entity);
    log.debug("Created {}", entity);
    return favoriteMapper.toFavoriteDTO(createdEntity);
  }
}

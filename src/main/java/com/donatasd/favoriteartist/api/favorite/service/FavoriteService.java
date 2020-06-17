package com.donatasd.favoriteartist.api.favorite.service;

import com.donatasd.favoriteartist.api.favorite.dto.CreateFavoriteDTO;
import com.donatasd.favoriteartist.api.favorite.mapper.FavoriteMapper;
import com.donatasd.favoriteartist.api.favorite.repository.FavoriteRepository;
import com.donatasd.favoriteartist.api.user.User;
import com.donatasd.favoriteartist.api.user.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Donatas Daubaras
 */
@Service
@Slf4j
public class FavoriteService {

  private final FavoriteRepository favoriteRepository;

  private final UserRepository userRepository;

  private final FavoriteMapper favoriteMapper;

  public FavoriteService(
      FavoriteRepository favoriteRepository,
      UserRepository userRepository,
      FavoriteMapper favoriteMapper
  ) {
    this.favoriteRepository = favoriteRepository;
    this.userRepository = userRepository;
    this.favoriteMapper = favoriteMapper;
  }

  public FavoriteDTO createFavorite(CreateFavoriteDTO createDTO) {
    log.debug("Saving {}", createDTO);
    var entity = favoriteMapper.toFavorite(createDTO);
    var createdEntity = favoriteRepository.save(entity);
    log.debug("Created {}", entity);
    return favoriteMapper.toFavoriteDTO(createdEntity);
  }

  public List<FavoriteDTO> findAllByUserId(Long userId) {
    log.debug("Find All by userId: {}", userId);
    var entities = userRepository.findById(userId)
        .map(User::getFavorites)
        .orElse(List.of());

    return entities.stream()
        .map(favoriteMapper::toFavoriteDTO)
        .collect(Collectors.toList());
  }
}

package com.donatasd.favoriteartist.api.favorite.mapper;

import com.donatasd.favoriteartist.api.favorite.dto.CreateFavoriteDTO;
import com.donatasd.favoriteartist.api.favorite.entity.Favorite;
import com.donatasd.favoriteartist.api.favorite.service.FavoriteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Donatas Daubaras
 */
@Mapper(componentModel = "spring")
public interface FavoriteMapper {

  @Mapping(target = "id", ignore = true)
  Favorite toFavorite(CreateFavoriteDTO dto);

  FavoriteDTO toFavoriteDTO(Favorite favorite);
}

package com.donatasd.favoriteartist.api.favorite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author Donatas Daubaras
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateFavoriteDTO {

  @NonNull
  private Long userId;

  @NonNull
  private Long amgArtistId;
}

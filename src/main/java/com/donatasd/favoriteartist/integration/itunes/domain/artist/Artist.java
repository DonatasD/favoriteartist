package com.donatasd.favoriteartist.integration.itunes.domain.artist;

import com.donatasd.favoriteartist.integration.itunes.domain.BaseResponseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Donatas Daubaras
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Artist extends BaseResponseEntity {

  private String artistType;

  private String artistName;

  private String artistLinkUrl;

  private Long artistId;

  private String primaryGenreName;

  private Long primaryGenreId;

  private Long amgArtistId;
}

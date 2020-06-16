package com.donatasd.favoriteartist.integration.itunes.domain.collection;

import com.donatasd.favoriteartist.integration.itunes.domain.BaseResponseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Donatas Daubaras
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Collection extends BaseResponseEntity {

  private String collectionType;

  private Long artistId;

  private Long collectionId;

  private Long amgArtistId;

  private String artistName;

  private String collectionName;

  private String collectionCensoredName;

  private String artistViewUrl;

  private String collectionViewUrl;

  private String artworkUrl60;

  private String artworkUrl100;

  private Double collectionPrice;

  private String collectionExplicitness;

  private Long trackCount;

  private String copyright;

  private String country;

  private String currency;

  private String releaseDate;

  private String primaryGenreName;
}

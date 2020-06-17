package com.donatasd.favoriteartist.api.favorite.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

/**
 * @author Donatas Daubaras
 */
@Entity
@Data
@NoArgsConstructor
public class Favorite {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;


  @NonNull
  @Column(nullable = false)
  private Long amgArtistId;
}

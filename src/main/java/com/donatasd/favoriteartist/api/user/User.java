package com.donatasd.favoriteartist.api.user;

import com.donatasd.favoriteartist.api.favorite.entity.Favorite;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Donatas Daubaras
 */
@Entity
public class User {

  @Id
  private Long id;

  @OneToMany
  private List<Favorite> favorites;

}

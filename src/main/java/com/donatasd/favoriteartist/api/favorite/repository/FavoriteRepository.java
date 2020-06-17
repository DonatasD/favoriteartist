package com.donatasd.favoriteartist.api.favorite.repository;

import com.donatasd.favoriteartist.api.favorite.entity.Favorite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Donatas Daubaras
 */
@Repository
public interface FavoriteRepository extends CrudRepository<Favorite, Long> {

}

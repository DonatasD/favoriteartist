package com.donatasd.favoriteartist.integration.itunes.domain.artist;

import com.donatasd.favoriteartist.integration.itunes.domain.Response;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Donatas Daubaras
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArtistResponseWrapper extends Response<Artist> {

}

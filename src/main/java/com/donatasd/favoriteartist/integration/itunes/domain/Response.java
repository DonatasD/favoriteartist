package com.donatasd.favoriteartist.integration.itunes.domain;

import java.util.List;
import lombok.Data;

/**
 * @author Donatas Daubaras
 */
@Data
public class Response<T extends BaseResponseEntity> {

  private Long resultCount;

  private List<T> results;

}

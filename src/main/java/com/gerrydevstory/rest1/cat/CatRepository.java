package com.gerrydevstory.rest1.cat;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CatRepository extends PagingAndSortingRepository<Cat, Long> {

}

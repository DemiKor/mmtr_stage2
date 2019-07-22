package com.mmtr.repositories;

import com.mmtr.models.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Integer> {

}

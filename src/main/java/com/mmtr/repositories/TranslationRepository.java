package com.mmtr.repositories;

import com.mmtr.models.Translation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TranslationRepository extends CrudRepository<Translation, Integer> {
    Translation findByName(String name);
    boolean existsByName(String name);
    void deleteByName(String name);
}

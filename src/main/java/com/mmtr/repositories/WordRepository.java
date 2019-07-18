package com.mmtr.repositories;

import com.mmtr.models.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends CrudRepository<Word, Integer> {
    Word findByName(String name);
    boolean existsByName(String name);
    void deleteByName(String name);
}

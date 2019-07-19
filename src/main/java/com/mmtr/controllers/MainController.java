package com.mmtr.controllers;


import com.mmtr.models.Translation;
import com.mmtr.models.Word;
import com.mmtr.models.WordForAdd;
import com.mmtr.repositories.TranslationRepository;
import com.mmtr.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MainController {

    @Autowired
    WordRepository wordRepository;
    @Autowired
    TranslationRepository translationRepository;

    @GetMapping("/words")
    public ArrayList<Word> getAllWords(){
        ArrayList<Word> list = new ArrayList<>();
        for(Word t : wordRepository.findAll()){
            list.add(t);
        }
        return list;
    }

    @GetMapping("/word/{word}")
    public Word getWord(@PathVariable String word){
        return wordRepository.findByName(word);
    }

    @DeleteMapping("/word/delete/{word}")
    public boolean deleteWord(@PathVariable String word){
        try {
            Word word1 = getWord(word);
            wordRepository.deleteById(word1.getId());
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @PostMapping("/word")
    public boolean addWord(@RequestBody WordForAdd wordForAdd){
        try{
            Translation translation = translationRepository.findByName(wordForAdd.getTranslation());
            if(translation == null) translation = new Translation(wordForAdd.getTranslation());
            Word word = new Word(wordForAdd.getName(),wordForAdd.getRegex(),translation);
            wordRepository.save(word);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  false;
        }
    }

    @PutMapping("/word")
    public boolean updateWord(@RequestBody WordForAdd wordForAdd){
        try{
            Translation translation = translationRepository.findByName(wordForAdd.getTranslation());
            if(translation == null) translation = new Translation(wordForAdd.getTranslation());
            Word word = new Word(wordForAdd.getName(),wordForAdd.getRegex(),translation);
            if(wordRepository.existsByName(word.getName()))
                deleteWord(word.getName());
            wordRepository.save(word);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  false;
        }
    }
}

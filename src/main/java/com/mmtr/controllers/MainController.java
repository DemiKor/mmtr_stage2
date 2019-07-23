package com.mmtr.controllers;

import com.mmtr.models.Library;
import com.mmtr.models.Translation;
import com.mmtr.models.Word;
import com.mmtr.models.WordForAdd;
import com.mmtr.repositories.LibraryRepository;
import com.mmtr.repositories.TranslationRepository;
import com.mmtr.repositories.WordRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.Response;

import javax.websocket.server.PathParam;
import javax.xml.ws.http.HTTPException;
import java.util.ArrayList;

@Api(value = "Libraries", description = "API for libraries")
@RestController
public class MainController {

    @Autowired
    WordRepository wordRepository;
    @Autowired
    TranslationRepository translationRepository;
    @Autowired
    LibraryRepository libraryRepository;

    @GetMapping("/words")
    public Resources<Word> getAllWords(){
        ArrayList<Word> list = new ArrayList<>();
        for(Word t : wordRepository.findAll()){
            list.add(t);
        }
        return new Resources<>(list);
    }

    @GetMapping("/words/{id}")
    public Word getWord(@PathVariable String word){
        return wordRepository.findByName(word);
    }

    @DeleteMapping("/words/{id}")
    public Response deleteWord(@PathParam("id") Integer id){
        try {
            wordRepository.deleteById(id);
            return Response.status(200).entity("OK").build();
        }catch (HTTPException e){
            System.out.println(e.getMessage());
            return Response.status(e.getStatusCode()).entity(e.getMessage()).build();
        }catch (Exception er){
            System.out.println(er.getMessage());
            return Response.status(500).entity(er.getMessage()).build();
        }
    }

    @PostMapping("/words")
    public ResponseEntity<?> addWord(@RequestBody WordForAdd wordForAdd){
        try{
            Word word = makeWord(wordForAdd);
            return new ResponseEntity<>(word, HttpStatus.OK);
        }catch (HTTPException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.resolve(e.getStatusCode()));
        }catch (Exception er){
            System.out.println(er.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/words/{id}")
    public ResponseEntity<?> updateWord(@RequestBody WordForAdd wordForAdd, @PathParam("id") Integer id){
        try{
            Word word = makeWord(wordForAdd);
            word.setId(id);
            if(wordRepository.existsById(id))
                deleteWord(id);
            return new ResponseEntity<>(word, HttpStatus.OK);
        }catch (HTTPException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.resolve(e.getStatusCode()));
        }catch (Exception er){
            System.out.println(er.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Word makeWord(WordForAdd wordForAdd) throws Exception{
        Translation translation = translationRepository.findByName(wordForAdd.getTranslation());
        if(translation == null)
        {
            translation = new Translation(wordForAdd.getTranslation());
            translationRepository.save(translation);
        }
        Library library = libraryRepository.findById(wordForAdd.getRegex()).get();
        if(!wordForAdd.getName().matches(library.getRegex())){
            System.out.println("Regulyarka");
            throw new Exception("Regulyarka");
        }
        Word word = new Word(wordForAdd.getName(),library,translation);
        return  word;
    }
}

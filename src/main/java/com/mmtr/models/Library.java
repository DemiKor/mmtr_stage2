package com.mmtr.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "lib")
public class Library {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @OneToOne(mappedBy = "word")
    @Column(name = "regex")
    private String regex;

//    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
//    private Collection<Word> words;

    public Library(String regex) {
        this.regex = regex;
    }

    protected Library() {}

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Integer getId() {
        return id;
    }

//    public Collection<Word> getWords() {
//        return words;
//    }
//
//    public void setWords(Collection<Word> words) {
//        this.words = words;
//    }
}

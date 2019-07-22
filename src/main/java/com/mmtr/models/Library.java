package com.mmtr.models;

import javax.persistence.*;

@Entity
@Table(name = "lib")
public class Library {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "regex")
    private String regex;

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

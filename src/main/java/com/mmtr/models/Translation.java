package com.mmtr.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "translation")
public class Translation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "translation", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Word> words = new HashSet<Word>();

    public Translation( String name) {
        this.name = name;
    }

    protected Translation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public Set<Word> getWords() {
//        return words;
//    }
//
//    public void setWords(Set<Word> words) {
//        this.words = words;
//    }
}

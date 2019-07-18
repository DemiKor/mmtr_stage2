package com.mmtr.models;

import javax.persistence.*;

@Entity
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "regex")
    private String regex;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="translation_id")
    private Translation translation;

    public Word(String name, String regex, Translation translation) {
        this.name = name;
        this.regex = regex;
        this.translation = translation;
    }

    protected Word() {  }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Translation getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }
}

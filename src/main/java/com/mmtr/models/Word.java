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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="lib_id")
    private Library library;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="translation_id")
    private Translation translation;

    public Word(String name, Library library, Translation translation) {
        this.name = name;
        this.library = library;
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

    public Library getlibrary() {
        return library;
    }

    public void setlibrary(Library library) {
        this.library = library;
    }

    public Translation getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }
}

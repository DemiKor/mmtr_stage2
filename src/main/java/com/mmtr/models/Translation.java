package com.mmtr.models;

import javax.persistence.*;


@Entity
@Table(name = "translation")
public class Translation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @OneToOne(mappedBy = "word")
    @Column(name = "name")
    private String name;

    public Translation( String name) {
        this.name = name;
    }
    protected Translation() {
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

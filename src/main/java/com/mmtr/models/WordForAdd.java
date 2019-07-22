package com.mmtr.models;

public class WordForAdd {
    private String name;
    private Integer regex;
    private String translation;

    public WordForAdd(String name, Integer regex, String translation) {
        this.name = name;
        this.regex = regex;
        this.translation = translation;
    }

    protected WordForAdd() {  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegex() {
        return regex;
    }

    public void setRegex(Integer regex) {
        this.regex = regex;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}

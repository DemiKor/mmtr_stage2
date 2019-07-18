package com.mmtr.models;

public class WordForAdd {
    private String name;
    private String regex;
    private String translation;

    public WordForAdd(String name, String regex, String translation) {
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

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}

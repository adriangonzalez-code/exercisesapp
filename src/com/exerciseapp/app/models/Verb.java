package com.exerciseapp.app.models;

public class Verb {

    private String verb;
    private String meaning;

    public Verb() {
    }

    public Verb(String verb, String meaning) {
        this.verb = verb;
        this.meaning = meaning;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
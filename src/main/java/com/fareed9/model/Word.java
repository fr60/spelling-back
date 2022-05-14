package com.fareed9.model;

import com.fareed9.Helper;

public class Word {
    private int id;
    private String text;
    private String masked;

    public Word(int id, String text) {
        this.id = id;
        this.text = text;
        this.masked = Helper.mask(text);
    }

    public boolean matched(String string){
        return string.trim().toLowerCase()
                .equals(
                        this.text.trim().toLowerCase()
                );
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMasked() {
        return masked;
    }

    public void setMasked(String masked) {
        this.masked = masked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}

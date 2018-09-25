package com.example.josh.envoycodetest;

import java.io.Serializable;

// Class to hold data related to a Gist File
public class GistFile implements Serializable{
    private String fileName;
    private String type;
    private String language;
    private String rawUrl;
    private int size;

    public GistFile(String fileName, String type, String language, String rawUrl, int size) {
        this.fileName = fileName;
        this.type = type;
        this.language = language;
        this.rawUrl = rawUrl;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRawUrl() {
        return rawUrl;
    }

    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

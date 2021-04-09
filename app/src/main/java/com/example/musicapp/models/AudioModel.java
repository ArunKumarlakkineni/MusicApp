package com.example.musicapp.models;

public class AudioModel {

    String aName;
    String aAlbum;
    String aArtist;
    String aPath;
    public AudioModel(String path,String name,String album,String artist){
        this.aPath=path;
        this.aName=name;
        this.aAlbum=album;
        this.aArtist=artist;
    }

    public String getPath() {
        return aPath;
    }

    public void setPath(String aName) {
        this.aPath = aPath;
    }

    public String getName() {
        return aName;
    }

    public void setName(String aName) {
        this.aName = aName;
    }

    public String getAlbum() {
        return aAlbum;
    }

    public void setAlbum(String aAlbum) {
        this.aAlbum = aAlbum;
    }

    public String getArtist() {
        return aArtist;
    }

    public void setArtist(String aArtist) {
        this.aArtist = aArtist;
    }

}
package com.example.f22comp1011s1w1;

import java.time.LocalDate;
import java.util.*;

public class Song {
    private String Name,genre;
    private int releaseYear,length;
    private Artist artist;

    public Song(String name, String genre, int releaseYear, int length, Artist artist) {
        setName(name);
        setGenre(genre);
        setReleaseYear(releaseYear);
        setLength(length);
        setArtist(artist);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        name = name.trim(); //remove any spaces
        if(!name.isBlank()){
            Name = name;
        }else{
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        genre = genre.toLowerCase();
        if(getGenres().contains(genre)){
            this.genre = genre;
        }else{
            throw new IllegalArgumentException(genre + "is Invalid Genre, must be of type" + getGenres());
        }
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        if(releaseYear >=1900 && releaseYear<= LocalDate.now().getYear()){
            this.releaseYear = releaseYear;
        }else{
            throw new IllegalArgumentException("release year must be between 1900 and "+ LocalDate.now().getYear());
        }

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if(length >0 && length <=5500){
            this.length = length;
        }else{
            throw new IllegalArgumentException("song must be between 0 and 5500 seconds");
        }

    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {

        this.artist = artist;
    }

    public static List<String> getGenres(){
        List<String> list = Arrays.asList("pop","rock","sole","jazz","metal",
                "punk","country","mellow","electric","classical","rhythm","folk"
        ,"dance");

        Collections.sort(list);
        return list;
    }
    public String toString(){
        return String.format("%s - %s ", artist,getName());
    }
}

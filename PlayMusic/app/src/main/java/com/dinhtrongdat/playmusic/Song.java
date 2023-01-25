package com.dinhtrongdat.playmusic;

public class Song {
    private String title;
    private int file;
    private int img;

    public Song(String title, int file, int img) {
        this.title = title;
        this.file = file;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

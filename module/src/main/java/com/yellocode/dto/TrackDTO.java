package com.yellocode.dto;


public class TrackDTO {

    private Long id;
    private String trackName;
    private String trackAuthor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackAuthor() {
        return trackAuthor;
    }

    public void setTrackAuthor(String trackAuthor) {
        this.trackAuthor = trackAuthor;
    }

    @Override
    public String toString() {
        return "TrackDTO{" +
                "id=" + id +
                ", trackName='" + trackName + '\'' +
                ", trackAuthor='" + trackAuthor + '\'' +
                '}';
    }
}

package com.yellocode.dao.entity;


public class TrackEntity extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String trackName;

    private String trackAuthor;

    private Integer playlistID;

    public TrackEntity(){super();}

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Integer getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(Integer playlistID) {
        this.playlistID = playlistID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TrackEntity that = (TrackEntity) o;

        if (!trackName.equals(that.trackName)) return false;
        if (!trackAuthor.equals(that.trackAuthor)) return false;
        return playlistID.equals(that.playlistID);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + trackName.hashCode();
        result = 31 * result + trackAuthor.hashCode();
        result = 31 * result + playlistID.hashCode();
        return result;
    }
}

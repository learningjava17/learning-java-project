package com.yellocode.dao.entity;


public class PlaylistEntity extends AbstractEntity{

    private static final long serialVersionUID = 1L;

    private String playlistName;

    private Integer userID;

    public PlaylistEntity(){super();}

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PlaylistEntity that = (PlaylistEntity) o;

        if (!playlistName.equals(that.playlistName)) return false;
        return userID.equals(that.userID);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + playlistName.hashCode();
        result = 31 * result + userID.hashCode();
        return result;
    }
}

package com.yellocode.dto;

import com.yellocode.domain.Playlist;


public class PlaylistDTO {

    private Long id;
    private String playlistName;
    private TrackDTO trackDTO;

    public PlaylistDTO(Playlist playlist) {
        this.id = getId();
        this.playlistName = getPlaylistName();
        this.trackDTO = getTrackDTO();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public TrackDTO getTrackDTO() {
        return trackDTO;
    }

    public void setTrackDTO(TrackDTO trackDTO) {
        this.trackDTO = trackDTO;
    }

    @Override
    public String toString() {
        return "PlaylistDTO{" +
                "id=" + id +
                ", playlistName='" + playlistName + '\'' +
                ", trackDTO=" + trackDTO +
                '}';
    }
}

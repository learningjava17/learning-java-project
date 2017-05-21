package com.yellocode.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "playlist_name", nullable = false, insertable = true, updatable = true, length = 255)
    private String playlistName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "track_playlist", joinColumns = {
            @JoinColumn(name = "playlist_id", nullable = false, updatable = true)
    }, inverseJoinColumns = { @JoinColumn(name = "track_id", nullable = false, updatable = true) })
    private List<Track> tracks;

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

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", playlistName='" + playlistName + '\'' +
                ", tracks=" + tracks +
                '}';
    }
}

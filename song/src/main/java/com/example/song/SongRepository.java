package com.example.song;

import java.util.ArrayList;

interface SongRepository {
    ArrayList<Song> getSongs();

    Song getSongById(int id);

    Song postSong(Song song);

    Song updateSong(int id, Song song);

    void deleteSong(int id);
}
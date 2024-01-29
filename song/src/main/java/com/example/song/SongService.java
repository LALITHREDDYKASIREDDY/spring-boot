
package com.example.song;

import java.util.*;
import java.util.ArrayList;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    private int id = 6;

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    @Override
    public ArrayList<Song> getSongs() {
        Collection<Song> songs = playlist.values();
        ArrayList<Song> allsongs = new ArrayList<>(songs);
        return allsongs;
    }

    @Override
    public Song postSong(Song song) {
        song.setSongId(id);
        playlist.put(id, song);
        id++;
        return song;
    }

    @Override
    public Song getSongById(int id) {
        Song song = playlist.get(id);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return song;
    }

    @Override
    public Song updateSong(int id,Song song){
        Song original=playlist.get(id);
        if(original==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(song.getSinger()!=null){
            original.setSiinger(song.getSinger());
        }
        if(song.getLyricist()!=null){
            original.setLyricist(song.getLyricist());
        }
        if(song.getMusicDirector()!=null){
            original.setMusicDirector(song.getMusicDirector());
        }
        if(song.getSongName()!=null){
            original.setSongName(song.getSongName());
        }
        playlist.put(id,original);
        return original;
    }
    @Override
    public void deleteSong(int id){
         Song song=playlist.get(id);
        if(song==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        playlist.remove(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}
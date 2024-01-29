package com.example.song;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SongController {
    SongService s = new SongService();

    @GetMapping("/songs")
    public ArrayList<Song> getsongs() {
        return s.getSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getsongbyid(@PathVariable("songId") int id) {
        return s.getSongById(id);
    }

    @PostMapping("/songs")
    public Song postsong(@RequestBody Song song) {
        return s.postSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song update(@PathVariable("songId") int id, @RequestBody Song song) {
        return s.updateSong(id, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void delete(@PathVariable("songId") int id) {
        s.deleteSong(id);
    }
}
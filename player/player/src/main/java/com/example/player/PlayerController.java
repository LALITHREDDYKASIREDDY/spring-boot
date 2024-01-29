package com.example.player;


import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class PlayerController {
    PlayerService b = new PlayerService();

    @GetMapping("/players")
    public ArrayList<Player> getBooks() {

        return b.getPlayers();
    }

    @GetMapping("/players/{playerId}")
    public Player getBookById(@PathVariable("playerId") int playerId) {
        return b.getPlayerById(playerId);
    }

    @PostMapping("/players")
    public Player postMethodName(@RequestBody Player player) {
        return b.addPlayer(player);
    }

    @PutMapping("/players/{playerId}")
    public Player putMethodName(@PathVariable("playerId") int id, @RequestBody Player player) {
        return b.updatePlayer(id, player);
    }

    @DeleteMapping("/players/{playerId}")
    public void deleteBookId(@PathVariable("playerId") int id) {
        b.deletePlayer(id);

    }
}

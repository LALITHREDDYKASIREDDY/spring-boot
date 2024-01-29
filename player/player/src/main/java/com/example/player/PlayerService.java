
package com.example.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class PlayerService implements PlayerRepository {

    private static HashMap<Integer, Player> team = new HashMap<>();
    private int id = 12;

    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));
    }

    @Override
    public ArrayList<Player> getPlayers() {
        Collection<Player> players = team.values();
        ArrayList<Player> playerList = new ArrayList<>(players);
        return playerList;
    }

    @Override

    public Player getPlayerById(int id) {
        Player play = team.get(id);
        if (play == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return play;
    }

    @Override
    public Player addPlayer(Player player) {
        player.setPlayerId(id);
        team.put(id, player);
        id++;
        return player;
    }

    @Override
    public Player updatePlayer(int id, Player player) {
        Player orginal = team.get(id);
        if (orginal == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (player.getPlayerName() != null) {
            orginal.setPlayerName(player.getPlayerName());
        }
        if (player.getJerseyNumber() != orginal.getJerseyNumber()) {
            orginal.setJerseyNumber(player.getJerseyNumber());
        }

        if (player.getRole() != null) {
            orginal.setRole(player.getRole());
        }
        team.put(orginal.getPlayerId(), orginal);
        return orginal;
    }

    @Override
    public void deletePlayer(int id) {
        Player player = team.get(id);
        if (player == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        team.remove(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}

package com.example.player;
import java.util.ArrayList;

interface PlayerRepository {
    ArrayList<Player> getPlayers();

    Player getPlayerById(int id);

    Player addPlayer(Player player);

    Player updatePlayer(int id, Player player);

    void deletePlayer(int id);
}
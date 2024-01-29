package com.example.player;
public class Player {
  private int playerId;
  private String playerName;
  private int jerseyNumber;
  private String role;

  public Player(int playerId, String playerName, int jerseyNumber, String role) {
    this.jerseyNumber = jerseyNumber;
    this.playerId = playerId;
    this.role = role;
    this.playerName = playerName;
  }

  public int getPlayerId() {
    return playerId;
  }

  public int getJerseyNumber() {
    return jerseyNumber;
  }

  public String getPlayerName() {
    return playerName;
  }

  public String getRole() {
    return role;
  }

  public void setPlayerId(int playerId) {
    this.playerId = playerId;
  }

  public void setJerseyNumber(int jerseyNumber) {
    this.jerseyNumber = jerseyNumber;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public void setRole(String role) {
    this.role = role;
  }

}
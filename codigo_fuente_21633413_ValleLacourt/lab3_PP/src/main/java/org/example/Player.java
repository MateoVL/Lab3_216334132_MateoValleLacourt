package org.example;

public class Player implements Tda_Player {
    //atributos
    private int id;
    private String name;
    private String color;
    private int wins;
    private int losses;
    private int draws;
    private int remaining_pieces;

    //metodos
    //constructor
    //RF03
    public Player(int id, String name, String color, int wins, int losses, int draws, int remaining_pieces) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.remaining_pieces = remaining_pieces;
    }
    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", wins=" + wins +
                ", losses=" + losses +
                ", draws=" + draws +
                ", remaining_pieces=" + remaining_pieces +
                '}';
    }
}

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
    public Player(String name, String color, int remaining_pieces) {
        countId=countId+1;
        this.id = countId;
        this.name = name;
        this.color = color;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.remaining_pieces = remaining_pieces;
    }

    //Selectores
    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getRemaining_pieces() {
        return remaining_pieces;
    }
    @Override
    public String getName() {
        return name;
    }

    //Modificadores
    @Override
    public void sub_pieces(){
        remaining_pieces--;
    }

    //Otros
    //RF15
    @Override
    public void update_stats(String resultado){
        if(resultado.equals("win")){
            this.wins += 1;
        }
        if(resultado.equals("loss")){
            this.losses += 1;
        }
        if(resultado.equals("draw")){
            this.draws += 1;
        }
    }

    @Override
    public void show_stats(){
        System.out.println(name + "("+color+")");
        System.out.println("Victorias: " + wins);
        System.out.println("Derrotas: " + losses);
        System.out.println("Empates: " + draws);
    }

    private static int countId = 0;
}

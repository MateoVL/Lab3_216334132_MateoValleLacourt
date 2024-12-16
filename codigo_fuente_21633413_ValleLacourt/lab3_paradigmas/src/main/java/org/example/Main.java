package org.example;

public class Main {
    public static void main(String[] args) {
        //Piece pieza_roja = new Piece("rojo");
        //System.out.println(pieza_roja.pieza);

        Player p1 = new Player(1, "Mateo", "rojo", 0,0,0,21);
        System.out.println(p1);

        Board b = new Board();
        b.mostrarTablero();
    }
}
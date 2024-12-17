package org.example;

public class Main {
    public static void main(String[] args) {
        Piece pieza_roja = new Piece("rojo");
        Piece pieza_amarilla = new Piece("amarillo");
        //System.out.println(pieza_roja.pieza);

        Player p1 = new Player(1, "Mateo", "rojo", 0,0,0,21);
        System.out.println(p1);

        Board b = new Board();
        b.setP1(pieza_roja.pieza);
        b.setP2(pieza_amarilla.pieza);
        b.mostrarTablero();

        System.out.println(b.can_play());

        b.play_piece(0, pieza_roja);
        b.mostrarTablero();
        b.play_piece(1, pieza_amarilla);
        b.mostrarTablero();

    }
}
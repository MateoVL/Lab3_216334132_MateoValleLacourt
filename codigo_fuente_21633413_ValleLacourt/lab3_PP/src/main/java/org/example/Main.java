package org.example;

public class Main {
    public static void main(String[] args) {
        Piece pieza_roja = new Piece("rojo");
        Piece pieza_amarilla = new Piece("amarillo");
        //System.out.println(pieza_roja.pieza);

        Player p1 = new Player(1, "Mateo", "rojo", 0,0,0,21);
        System.out.println(p1);

        Player p2 = new Player(2, "Juan", "amarillo", 0,0,0,21);
        System.out.println(p1);

        Board b = new Board();
        b.setPiece1(p1);
        b.setPiece2(p2);
        b.mostrarTablero();

        System.out.println(b.can_play());

        b.play_piece(0, pieza_roja);
        b.mostrarTablero();
        b.play_piece(1, pieza_amarilla);
        b.mostrarTablero();

        Game g1 = new Game();
        g1.setPlayer1(p1);
        g1.setPlayer2(p2);
        System.out.println(g1);

    }
}
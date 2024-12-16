package org.example;

public class Piece {
    String pieza;

    public Piece(String color) {
        char caracter = Character.toUpperCase(color.charAt(0));
        this.pieza = "(" + caracter + ")";
    }
}

package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game juego = new Game();
        Player jugador1;
        Player jugador2;
        Scanner input = new Scanner(System.in);

        System.out.println("Bienvenido a Conecta-4");
        final int SALIDA_MENU = 6;
        int choice;
        do {
            imprimirMenu();
            choice = input.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("\n-- Configuracion Jugador 1 --");
                    System.out.print("Ingrese nombre del jugador 1: ");
                    String nombreP1 = input.next();
                    System.out.print("Ingrese el color del jugador 1: ");
                    String color1 = input.next();

                    System.out.println("\n-- Configuracion Jugador 2 --");
                    System.out.print("Ingrese nombre del jugador 2: ");
                    String nombreP2 = input.next();
                    System.out.print("Ingrese el color del jugador 2: ");
                    String color2 = input.next();

                    System.out.println("\n-- Configuración de juego --");
                    System.out.print("Ingrese la cantidad de fichas (4-21): ");
                    int cantFichas = input.nextInt();

                    jugador1 = new Player(nombreP1, color1, cantFichas);
                    jugador2 = new Player(nombreP2, color2, cantFichas);
                    juego = new Game(jugador1, jugador2);
                    break;

                case 2:
                    System.out.println("### Estado del juego ###");
                    if(juego.getBoard() == null){
                        System.out.println("No se ha creado ningún juego.");
                    }
                    else juego.show_Board();
                    break;

                case 3:
                    System.out.println("### Realizar Jugada ###");
                    if (juego.getTurn()==1){
                        System.out.println("Turno de " + juego.getPlayer1().getName() +
                                "(" + juego.getPlayer1().getColor() + ")");
                        System.out.println("Cantidad de fichas: " + juego.getPlayer1().getRemaining_pieces());
                        System.out.println("\nSeleccione columna (1-7): ");
                        int columna = input.nextInt() - 1;
                        juego.player_set_move(juego.getPlayer1(), columna);
                    }
                    else if (juego.getTurn()==2){
                        System.out.println("Turno de " + juego.getPlayer2().getName() +
                                "(" + juego.getPlayer2().getColor() + ")");
                        System.out.println("Cantidad de fichas: " + juego.getPlayer2().getRemaining_pieces());
                        System.out.println("\nSeleccione columna (1-7): ");
                        int columna = input.nextInt() - 1;
                        juego.player_set_move(juego.getPlayer2(), columna);
                    }
                    System.out.println("### Movimiento realizado: ###");
                    juego.show_Board();
                    break;

                case 4:
                    System.out.println("### Estadísticas generales ###");
                    juego.getPlayer1().show_stats();
                    System.out.println();
                    juego.getPlayer2().show_stats();
                    break;

                case 5://mostrar historial
                    if(juego.getBoard()==null){
                        System.out.println("No se ha creado ningún juego.");
                    }
                    else{
                        juego.history();
                    }
                    break;

                case 6:
                    System.out.println("Gracias por jugar <3");
                    System.exit(0);
                    break;

                default:
                    System.out.println(choice + " no es una opción válida, seleccione una opción válida porfavor.");

            }
        } while (true);
    }

    private static void imprimirMenu() {
        System.out.println("\nMenu principal\n");
        System.out.print("1. Crear nuevo juego \n");
        System.out.print("2. Ver juego actual\n");
        System.out.print("3. Realizar jugada\n");
        System.out.print("4. Ver estadisticas\n");
        System.out.print("5. Ver historial de juego\n");
        System.out.print("6. Salir\n");
        System.out.print("\nIngrese opción: ");
    }
}

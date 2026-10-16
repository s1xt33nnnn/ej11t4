import java.util.Scanner;

public class ej11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] table;
        table = new char[8][8];
        initMatrix(table);
        int shots = 0, sunkShip = 0, selectLevel, numShip = 0;
        boolean gameOver = false;
        System.out.print("Selecciona el nivel de dificultad 1-5 siendo 5 el nivel más difícil: ");
        selectLevel = input.nextInt();
        numShip = levelSelection(selectLevel, numShip);
        boolean sunk = false;
        addShips(table, numShip);
        while (!gameOver) {
            System.out.println("-------------------------------------");
            printTable(table, true);
            if (sunk) {
                System.out.println("You have sunk a Ship");
            }
            int row = getRow(input);
            int col = getFil(input);
            shots++;
            if (table[row][col] == 'S') {
                table[row][col] = 'X';
                sunkShip++;
                sunk = true;
                if (sunkShip == numShip) {
                    gameOver = true;
                }
            } else {
                table[row][col] = 'O';
                sunk = false;
            }

        }
        if (sunkShip == numShip) {
            printGameWin(shots);
        }
    }

    private static void printGameWin(int shots) {
        System.out.println("  ____    _    __  __ _____  __        _____ _   _ ");
        System.out.println(" / ___|  / \\  |  \\/  | ____| \\ \\      / /_ _| \\ | |");
        System.out.println("| |  _  / _ \\ | |\\/| |  _|    \\ \\ /\\ / / | ||  \\| |");
        System.out.println("| |_| |/ ___ \\| |  | | |___    \\ V  V /  | || |\\  |");
        System.out.println(" \\____/_/   \\_\\_|  |_|_____|    \\_/\\_/  |___|_| \\_|");
        System.out.println("You have fired " + shots + " times to win");
    }

    private static int levelSelection(int selectLevel, int numShip) {
        if (selectLevel == 5) {
            numShip = 10;
        } else if (selectLevel == 4) {
            numShip = 15;
        } else if (selectLevel == 3) {
            numShip = 20;
        } else if (selectLevel == 2) {
            numShip = 25;
        } else if (selectLevel == 1) {
            numShip = 30;
        }
        return numShip;
    }

    private static void initMatrix(char[][] table) {
        for (int fila = 0; fila < table.length; fila++) {
            for (int col = 0; col < table[0].length; col++) {
                table[fila][col] = ' ';
            }
        }
    }

    static void addShips(char[][] tabla, int numShip) {
        int numShips = 0;
        while (numShips < numShip) {
            int row = (int) (Math.random() * tabla.length);
            int col = (int) (Math.random() * tabla[0].length);
            if (tabla[row][col] != 'S') {
                tabla[row][col] = 'S';
                numShips++;
            }
        }
    }

    static void printTable(char[][] tabla, boolean debug) {
        System.out.print("|   |");
        for (int i = 1; i <= 8; i++) {
            System.out.print(" " + i + " |");
        }
        System.out.println();
        char letter = 'A';
        for (int row = 0; row < tabla.length; row++) {
            System.out.println("|---|---|---|---|---|---|---|---|---|");
            System.out.print("| " + ((char) (65 + row)) + " | ");
            for (int col = 0; col < tabla[0].length; col++) {
                if (debug) {
                    System.out.print(tabla[row][col]);
                } else {
                    if (tabla[row][col] == 'S') {
                        System.out.print(" ");
                    } else {
                        System.out.print(tabla[row][col]);
                    }

                }
                System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");


    }


    static int getRow(Scanner input) {
        System.out.print("Dame la letra de la fila (en mayúsculas): ");
        char letter = input.next().charAt(0);
        int row = letter - 65;
        return row;
    }

    static int getFil(Scanner input) {
        System.out.print("Dame el numero de la columna: ");
        int col = input.nextInt() - 1;
        return col;
    }

}

import java.util.Scanner;

public class ej11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] table;
        table = new char[8][8];
        int cont = 0, shots = 0, sunk_ship = 0, ship = 0, getRow = 0, f = 0, c = 0;
        boolean gameOver = false;
        for (int fila = 0; fila < table.length; fila++) {
            for (int colum = 0; colum < table[0].length; colum++) {
                table[fila][colum] = ' ';
            }
        }
        for (int i = 1; i <= 10; i++) {
            f = (int) (Math.random() * 8);
            c = (int) (Math.random() * 8);
            table[f][c] = ' ';
        }
        while (!gameOver) {
            printTable(table);
            int row = getRow(input);
            int col = getfil(input);
        }
    }

    static void printTable(char[][] tabla) {
        System.out.print("|   |");
        for (int i = 1; i <= 8; i++) {
            System.out.print(" " + i + " |");
        }
        System.out.println();
        char letter = 'A';
        for (int row = 0; row < tabla.length; row++) {
            System.out.println("|---|---|---|---|---|---|---|---|---|");
            System.out.print("| " + (char) (65 + row) + " | ");
            for (int col = 0; col < tabla[0].length; col++) {
                System.out.print(tabla[row][col] + " | ");
            }
            System.out.println();

        }


    }


    static int getRow(Scanner input) {
        System.out.print("Dame la letra de la columna: ");
        char letter = input.next().charAt(0);
        int row = letter - 65;
        return row;
    }

    static int getfil(Scanner input) {
        System.out.print("Dame el numero de la fila: ");
        int col = input.nextInt() - 1;
        return col;
    }

}

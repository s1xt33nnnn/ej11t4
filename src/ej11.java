import java.util.Scanner;

public class ej11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] table;
        table = new char[8][8];
        int cont = 0, shots = 0, sunk_ship = 0, ship = 0, getRow = 0, f = 0, c = 0, selectLevel = 0, level = 0;
        boolean gameOver = false;
        System.out.print("Selecciona el nivel de dificultad 1-5 siendo 5 el nivel más difícil: ");
        selectLevel = input.nextInt();
        if (selectLevel >=4){
            level = 5;
        } else if (selectLevel >= 3) {
            level = 10;
        } else if (selectLevel >= 1) {
            level = 20;
        }
        addShips(table, level);
        for (int fila = 0; fila < table.length; fila++) {
            for (int colum = 0; colum < table[0].length; colum++) {
                table[fila][colum] = ' ';
            }
        }
        System.out.println("-------------------------------------");
        while (!gameOver) {
            printTable(table);
            int row = getRow(input);
            int col = getfil(input);

        }
    }
    static void addShips(char[][] tabla, int level){
        int numShips = 0;
        while (numShips < level ){

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
        System.out.println("-------------------------------------");


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

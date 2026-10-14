import java.util.Scanner;

public class ej11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] table;
        table = new char[8][8];
        for (int fila = 0; fila < table.length; fila++) {
            for (int col = 0; col < table[0].length; col++) {
                table[fila][col] = ' ';
            }
        }
        int cont = 0, shots = 0, sunk_ship = 0, ship = 0, selectLevel = 0, numship = 0;
        boolean gameOver = false;
        System.out.print("Selecciona el nivel de dificultad 1-5 siendo 5 el nivel más difícil: ");
        selectLevel = input.nextInt();
        if (selectLevel ==5){
            numship = 10;
        } else if (selectLevel == 4) {
            numship = 15;
        } else if (selectLevel == 3) {
            numship = 20;
        } else if (selectLevel == 2) {
            numship = 25;
        } else if (selectLevel == 1) {
            numship = 30;
        }

        addShips(table, numship);
        System.out.println("-------------------------------------");
        while (!gameOver) {
            printTable(table,true);
            int row = getRow(input);
            int col = getfil(input);
            if (table[row][col] == 'S') {
                table[row][col] = 'X';
            } else  {
                table[row][col] = 'O';
            }

        }
    }
    static void addShips(char[][] tabla, int numship){
        int numShips = 0;
        while (numShips < numship ){
            int row = (int) (Math.random()* tabla.length);
            int col = (int) (Math.random()* tabla[0].length);
            if (tabla[row][col] != 'S'){
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
            System.out.print("| " + ((char) (65 + row)) + " |");
            for (int col = 0; col < tabla[0].length; col++) {
                if (debug){
                    System.out.print(tabla[row][col]);
                } else {
                    if (tabla[row][col] == 'S');{
                        System.out.print(" ");
                    }
                }
                System.out.print(tabla[row][col] + " |");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");


    }


    static int getRow(Scanner input) {
        System.out.print("Dame la letra de la fila: ");
        char letter = input.next().charAt(0);
        int row = letter - 65;
        return row;
    }

    static int getfil(Scanner input) {
        System.out.print("Dame el numero de la columna: ");
        int col = input.nextInt() - 1;
        return col;
    }

}

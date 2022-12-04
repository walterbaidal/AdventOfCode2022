package main;

import java.io.*;

import game.Game;

public class App {

    public static String FILE = "C:\\Users\\xPrivi\\Desktop\\Walter\\dev\\Java\\AdventOfCode\\Day2\\src\\main\\oficial_guide.txt";
    public static String ROCK = "X"; // Rock 1
    public static String PAPER = "Y"; // Paper 2
    public static String SCISSORS = "Z"; // Scissors 3

    public static String LOSE = "X"; // Rock 1
    public static String DRAW = "Y"; // Paper 2
    public static String WIN = "Z"; // Scissors 3

    public static int POINTS_FOR_LOSE = 0; // Rock 1
    public static int POINTS_FOR_DRAW = 3; // Paper 2
    public static int POINTS_FOR_WIN = 6; // Scissors 3

    public static String ROCK_S = "A"; // Rock 1
    public static String PAPER_S = "B"; // Paper 2
    public static String SCISSORS_S = "C"; // Scissors 3

    public static BufferedReader readFile() throws FileNotFoundException {
        File file = new File(FILE);
        FileReader fr = new FileReader(file);
        return new BufferedReader(fr);
    }

    private static boolean doIWin(String opponent, String my_move) {
        if (my_move.equals("A")) {
            return opponent.equals("C");
        } else if (my_move.equals("B")) {
            return opponent.equals("A");
        } else if (my_move.equals("C")) {
            return opponent.equals("B");
        }
        return true;
    }

    private static int shapeValue(String my_move) {
        if (my_move.equals("A")) {
            return 1;
        } else if (my_move.equals("B")) {
            return 2;
        } else {
            return 3;
        }
    }

    private static int calculateRoundScore(String opponent, String my_move) {
        if (opponent.equals(my_move)) {
            return 3 + shapeValue(my_move);
        } else if (doIWin(opponent, my_move)) {
            return 6 + shapeValue(my_move);
        } else {
            return 0 + shapeValue(my_move);
        }
    }

    private static String renameMove(String shape) {
        if (shape.equals(ROCK)) {
            return "A";
        } else if (shape.equals(PAPER)) {
            return "B";
        } else {
            return "C";
        }
    }

    public static Game calculateGameResult() throws IOException {
        Game game = new Game();
        String currentLine;
        String my_move;
        String opponent;

        BufferedReader file = readFile();

        while ((currentLine = file.readLine()) != null) {
            String[] shape = currentLine.split(" ");
            opponent = shape[0];
            my_move = renameMove(shape[1]);
            game.addRoundScore(calculateRoundScore(opponent, my_move));
        }
        return game;
    }

    private static String shapeForLosing(String opponent) {
        String shape = "";
        if (opponent.equals(ROCK_S)) {
            shape = SCISSORS_S;
        } else if (opponent.equals(PAPER_S)) {
            shape = ROCK_S;
        } else {
            shape = PAPER_S;
        }
        return shape;
    }

    private static String shapeForWinning(String opponent) {
        String shape = "";
        if (opponent.equals(ROCK_S)) {
            shape = PAPER_S;
        } else if (opponent.equals(PAPER_S)) {
            shape = SCISSORS_S;
        } else {
            shape = ROCK_S;
        }
        return shape;
    }

    public static Game calculateGameResultWithSecretStrategy() throws IOException {
        Game game = new Game();
        String currentLine;
        String my_move;
        String opponent;
        int roundResult = 0;

        BufferedReader file = readFile();

        while ((currentLine = file.readLine()) != null) {
            String[] shape = currentLine.split(" ");
            opponent = shape[0];
            my_move = shape[1];
            if (my_move.equals(DRAW)) {
                roundResult = shapeValue(opponent) + POINTS_FOR_DRAW;
            } else if (my_move.equals(LOSE)) {
                roundResult = shapeValue(shapeForLosing(opponent)) + POINTS_FOR_LOSE;
            } else {
                roundResult = shapeValue(shapeForWinning(opponent)) + POINTS_FOR_WIN;
            }
            game.addRoundScore(roundResult);
        }

        return game;
    }

    public static void main(String[] args) throws Exception {
        Game game = calculateGameResult();
        System.out.println(game.getTotalScore());

        Game gameSecretStrategy = calculateGameResultWithSecretStrategy();
        System.out.println(gameSecretStrategy.getTotalScore());
    }

}

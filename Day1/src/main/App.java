package main;

import java.io.*;
import java.util.*;

import santa.Elf;

public class App {

    public static String FILE = "C:\\Users\\xPrivi\\Desktop\\Walter\\dev\\Java\\AdventOfCode\\Day1\\src\\main\\list.txt";

    public static BufferedReader readFile() throws FileNotFoundException {
        File file = new File(FILE);
        FileReader fr = new FileReader(file);
        return new BufferedReader(fr);
    }

    public static ArrayList<Elf> loadFoodOnElves() throws NumberFormatException, IOException {
        String currentLine;
        Elf elf = new Elf();
        ArrayList<Elf> elves = new ArrayList<Elf>();

        BufferedReader file = readFile();

        while ((currentLine = file.readLine()) != null) {
            if (!currentLine.isEmpty()) {
                elf.addFood(Integer.parseInt(currentLine));
            } else {
                elves.add(elf);
                elf = new Elf();
            }
        }
        elves.add(elf);
        return elves;
    }

    public static Elf whichElfCarryingTheMost(ArrayList<Elf> elves) throws NumberFormatException, IOException {
        Elf max = elves.stream().max(Comparator.comparing(Elf::getTotalCaloriesCarrying)).get();
        return max;
    }

    public static ArrayList<Elf> sortElvesByCaloriesCarried(ArrayList<Elf> elves) {
        elves.sort(Comparator.comparing(Elf::getTotalCaloriesCarrying));
        return elves;
    }

    public static int sumOfTop3ElvesCarryingCalories(ArrayList<Elf> elves) {
        List<Elf> topThreeElves = sortElvesByCaloriesCarried(elves).subList(elves.size() - 3, elves.size());
        return topThreeElves.stream().mapToInt(Elf::getTotalCaloriesCarrying).sum();
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Elf> elves = loadFoodOnElves();

        Elf elf = whichElfCarryingTheMost(elves);
        System.out.println(elf.getTotalCaloriesCarrying());

        int sum_top_three = sumOfTop3ElvesCarryingCalories(elves);
        System.out.println(sum_top_three);

    }
}

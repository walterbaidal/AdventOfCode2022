package santa;

import java.util.ArrayList;

public class Elf {
    private ArrayList<Integer> calories_per_food = new ArrayList<Integer>();

    public void addFood(int food) {
        this.calories_per_food.add(food);
    }

    public int getTotalCaloriesCarrying() {
        return this.calories_per_food.stream().mapToInt(i -> i.intValue()).sum(); // Programación declarativa
    }
}

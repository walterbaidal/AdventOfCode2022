package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import main.App;
import santa.Elf;

public class AppTest {
    @Test
    public void firstElfIsCarrying6000() throws Exception {

        ArrayList<Elf> elves = App.loadFoodOnElves();
        Elf firstElf = elves.get(0);

        assertEquals(6000, firstElf.getTotalCaloriesCarrying());
    }

    @Test
    public void secondElfIsCarrying4000() throws NumberFormatException, IOException {
        ArrayList<Elf> elves = App.loadFoodOnElves();
        Elf secondElf = elves.get(1);

        assertEquals(4000, secondElf.getTotalCaloriesCarrying());
    }

    @Test
    public void thirdElfIsCarrying110000() throws NumberFormatException, IOException {
        ArrayList<Elf> elves = App.loadFoodOnElves();
        Elf thirdElf = elves.get(2);

        assertEquals(11000, thirdElf.getTotalCaloriesCarrying());
    }

    @Test
    public void fourthElfIsCarrying24000() throws NumberFormatException, IOException {
        ArrayList<Elf> elves = App.loadFoodOnElves();
        Elf fourthElf = elves.get(3);

        assertEquals(24000, fourthElf.getTotalCaloriesCarrying());
    }

    @Test
    public void fifthElfIsCarrying10000() throws NumberFormatException, IOException {
        ArrayList<Elf> elves = App.loadFoodOnElves();
        Elf fifthElf = elves.get(4);

        assertEquals(10000, fifthElf.getTotalCaloriesCarrying());
    }

    @Test
    public void fourthElfIsCarryinTheMost() throws NumberFormatException, IOException {
        ArrayList<Elf> elves = App.loadFoodOnElves();
        int calories_fourth_elf_carrying = elves.get(3).getTotalCaloriesCarrying();
        int calories_elf_carrying_the_most = App.whichElfCarryingTheMost(elves).getTotalCaloriesCarrying();

        assertEquals(calories_fourth_elf_carrying, calories_elf_carrying_the_most);
    }

    @Test
    public void theSumOfTop3ElvesIs45000() throws NumberFormatException, IOException {
        ArrayList<Elf> elves = App.loadFoodOnElves();
        int calories_elf_4 = elves.get(3).getTotalCaloriesCarrying();
        int calories_elf_3 = elves.get(2).getTotalCaloriesCarrying();
        int calories_elf_5 = elves.get(4).getTotalCaloriesCarrying();

        int expected_total_top_3 = calories_elf_3 + calories_elf_4 + calories_elf_5;

        assertEquals(expected_total_top_3, App.sumOfTop3ElvesCarryingCalories(elves));

    }
}

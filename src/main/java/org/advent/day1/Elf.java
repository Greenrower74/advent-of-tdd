package org.advent.day1;

/**
 * Elf that is assigned calories
 */
public class Elf implements Comparable<Elf> {

    private int totalCalories = 0;

    /**
     * Adds the calories to the Elf's pack
     * @param calories to be carried
     */
    public void addCalories(int calories) {
        totalCalories += calories;
    }

    /**
     * Calories carried by the Elf
     * @return total calories
     */
    public int getTotalCalories() {
        return totalCalories;
    }

    @Override
    public int compareTo(Elf arg0) {
        return this.getTotalCalories() - arg0.getTotalCalories();
    }

}

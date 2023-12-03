package org.advent.day1;

/**
 * Elf that is assigned calories
 */
public class Elf implements Comparable<Elf> {

    private int totalCalories = 0;

    /**
     * Calories carried by the Elf
     * @return total calories
     */
    public int getTotalCalories() {
        return totalCalories;
    }

    /**
     * Adds calories to this elf for carrying
     * @param calories to add to total count for this elf
     */
    public void addCalories(int calories) {
        totalCalories += calories;
    }

    @Override
    public int compareTo(Elf that) {
        return this.getTotalCalories() - that.getTotalCalories();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Elf other)) return false;
        return this.getTotalCalories() == other.getTotalCalories();
    }
}
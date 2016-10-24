package Meal;

/**
 * @author Xiaoyuan Lai
 */
public class Recipe {
    private String name;
    private String description;
    private double cost;
    private int calories;

    public Recipe(String name, String description, double cost, int calories) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name + ":" + description + ":" + cost + ":" + calories;
    }
}

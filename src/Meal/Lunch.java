package Meal;

/**
 * @author Xiaoyuan Lai
 *
 * implement interface Meal
 * generate a meal for lunch
 *
 */
public class Lunch implements Meal {
    private Recipe recipe;
    private MealCategory mealCategory;

    /**
     * generate a random recipe in the given MealCategory type
     * @param mealCategory
     */
    public Lunch(MealCategory mealCategory) {
        this.mealCategory = mealCategory;
        this.recipe = mealCategory.getARecipe();
    }

    /**
     * @return returns the recipe it generate when initialize
     */
    @Override
    public Recipe getRecipe() {
        return this.recipe;
    }

    @Override
    public Integer getCalories() {
        return this.recipe.getCalories();
    }

    @Override
    public double getCost() {
        return this.recipe.getCost();
    }

    @Override
    public String getDetails() {
        return this.recipe.getName() + ": " + this.recipe.getDescription() + ", " + this.recipe.getCalories() + " calories, " + "$" + this.recipe.getCost();
    }

}

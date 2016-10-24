package Meal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Xiaoyuan Lai
 *
 * Implement the interface MealCategory
 * Keeps a list of Recipe by loading from a recipe.txt file
 * with a format as (recipeName:description:cost:calories) each line
 *
 */
public class HighCarbMeal implements MealCategory {
    private List<Recipe> recipeList;

    public HighCarbMeal() {
        recipeList = new ArrayList<Recipe>();
    }

    @Override
    public List<Recipe> showRecipes() {
        return recipeList;
    }

    /**
     *  randomly get a recipe from the list
     *  @return Recipe
     *  @return Will return null if there is nothing in the list
     *
     */
    @Override
    public Recipe getARecipe() {
        Random randomizer = new Random();
        if (recipeList.size() == 0) {
            return null;
        }
        Recipe randomRecipe = recipeList.get(randomizer.nextInt(recipeList.size()));
        return randomRecipe;
    }

    /**
     * Read a recipes.txt file and load each recipe to the list line by line.
     * Each line has a format as recipeName:description:cost:calories
     * If the format of one line is not valid, will print out a warning,
     * and this line will not be added to the list
     *
     * @param fileName
     * @throws IOException
     * @throws FileNotFoundException if the input of filename is not valid
     */
    @Override
    public void loadRecipes(String fileName) throws IOException {
        FileReader name = null;
        try {
            name = new FileReader(fileName);
        }
        catch (FileNotFoundException e) {
            System.out.println("Wrong file name!");
        }
        if (name != null) {
            BufferedReader reader = new BufferedReader(name);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] st = line.split("[:]+");
                if (st.length != 4) {
                    System.out.println("Line item not valid.");
                }
                else {
                    Recipe recipe = new Recipe(st[0], st[1], Double.parseDouble(st[2]), Integer.parseInt(st[3]));
                    recipeList.add(recipe);
                }
            }
            reader.close();
        }
    }
}

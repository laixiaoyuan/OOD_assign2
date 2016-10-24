package Meal;

import java.io.IOException;
import java.util.List;

/**
 * Created by Lexie on 10/17/16.
 */
public interface MealCategory {
    public List<Recipe> showRecipes();
    public Recipe getARecipe();
    public void loadRecipes(String FileName) throws IOException;
}

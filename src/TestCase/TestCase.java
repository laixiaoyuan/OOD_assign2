package TestCase;

import Meal.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xiaoyuan Lai
 * This is for test use only
 * including unit test, smoke test, integration test, regression test, etc
 */
public class TestCase {

    /**
     * This is to test classes of VeganMeal, LowCarbMeal, HighCarbMeal,
     * and how it goes when file name is invalid,
     * a line in the recipes.txt file does not follow the format of recipeName:description:cost:calories
     *
     * @throws IOException
     */
    public void testMealCategory() throws IOException {
        System.out.println("========Vegan Meal========");
        MealCategory veganMeal = new VeganMeal();
        veganMeal.loadRecipes("src/TestCase/vegan recipes");
        List<Recipe> recipeList = veganMeal.showRecipes();
        System.out.println(recipeList.size());
        System.out.println(Arrays.toString(recipeList.toArray()));
        Recipe recipe = veganMeal.getARecipe();
        System.out.println(recipe.toString());
        Recipe recipe1 = veganMeal.getARecipe();
        System.out.println(recipe1.toString());

        System.out.println("========Low Carb Meal========");
        MealCategory lowCarbMeal = new LowCarbMeal();
        lowCarbMeal.loadRecipes("src/TestCase/low-carb recipes");
        List<Recipe> recipeList1 = lowCarbMeal.showRecipes();
        System.out.println(recipeList1.size());
        System.out.println(Arrays.toString(recipeList1.toArray()));
        Recipe recipe2 = lowCarbMeal.getARecipe();
        System.out.println(recipe2.toString());
        Recipe recipe3 = lowCarbMeal.getARecipe();
        System.out.println(recipe3.toString());

        System.out.println("========High Carb Meal========");
        MealCategory highCarbMeal = new HighCarbMeal();
        highCarbMeal.loadRecipes("src/TestCase/high-carb recipes");
        List<Recipe> recipeList2 = highCarbMeal.showRecipes();
        System.out.println(recipeList2.size());
        System.out.println(Arrays.toString(recipeList2.toArray()));
        Recipe recipe4 = highCarbMeal.getARecipe();
        System.out.println(recipe4.toString());
        Recipe recipe5 = highCarbMeal.getARecipe();
        System.out.println(recipe5.toString());

        System.out.println("========Corner Case========");
        System.out.println("--------file not found--------");
        MealCategory mealCategory = new VeganMeal();
        mealCategory.loadRecipes("src/TestCase/vegan");
        mealCategory = new LowCarbMeal();
        mealCategory.loadRecipes("src/TestCase/low carb recipes");
        mealCategory = new HighCarbMeal();
        mealCategory.loadRecipes("src/TestCase/High carb ReciPEs");

        System.out.println("--------Recipe file line information not valid-------");
        MealCategory mealCategory1 = new VeganMeal();
        mealCategory1.loadRecipes("src/TestCase/vegan recipes test");
        List<Recipe> recipeList3 = mealCategory1.showRecipes();
        System.out.println(recipeList3.size());
        System.out.println(Arrays.toString(recipeList3.toArray()));
    }

    /**
     * This is to test the classes of Lunch, Dinner,
     * and how the cost of same recipe changes when the delivery fee for dinner changes.
     *
     * @throws IOException
     */
    public void testMeal() throws IOException {
        System.out.println("========Meal Test========");
        MealCategory veganMeal = new VeganMeal();
        veganMeal.loadRecipes("src/TestCase/vegan recipes");
        Meal lunch = new Lunch(veganMeal);
        System.out.println("........Creating a new Lunch........");
        System.out.println("Calories: " + lunch.getCalories());
        System.out.println("Cost: " + lunch.getCost());
        System.out.println(lunch.getDetails());
        Meal lunch1 = new Lunch(veganMeal);
        System.out.println("........Creating a new Lunch........");
        System.out.println("Calories: " + lunch1.getCalories());
        System.out.println("Cost: " + lunch1.getCost());
        System.out.println(lunch1.getDetails());

        MealCategory lowCarbMeal = new LowCarbMeal();
        lowCarbMeal.loadRecipes("src/TestCase/low-carb recipes");
        Meal dinner = new Dinner(lowCarbMeal);
        System.out.println("........Creating a new Dinner........");
        System.out.println("Calories: " + dinner.getCalories());
        System.out.println("Cost: " + dinner.getCost());
        System.out.println(dinner.getDetails());
        Dinner.setDeliveryFee(20);
        System.out.println("........Changing delivery fee in the system........");
        System.out.println(dinner.getDetails());
    }

    /**
     * This is to test the classes of VeganDietPlan, LowCarbDietPlan, HighCardDietPlan,
     * and how it goes when the lunch and dinner one plan generates for a same day have the same recipe,
     * when the day of week entered is invalid when creating a diet plan,
     * and when the recipes file name is not valid.
     *
     * @throws IOException
     */
    public void testDietPlan() throws IOException {
        System.out.println("======Diet Plan Test========");
        System.out.println("--------Vegan Meal--------");
        DietPlan veganDietPlan = new VeganDietPlan("src/TestCase/vegan recipes", 2);
        System.out.println(veganDietPlan.showPlan());
        System.out.println("Cost: " + veganDietPlan.getCost());

        System.out.println("--------Low Carb Meal--------");
        DietPlan lowCarbDietPlan = new LowCarbDietPlan("src/TestCase/low-carb recipes", 7);
        System.out.println(lowCarbDietPlan.showPlan());
        System.out.println("Cost: " + lowCarbDietPlan.getCost());

        System.out.println("--------High Carb Meal--------");
        DietPlan highCarbDietPlan = new HighCarbDietPlan("src/TestCase/high-carb recipes", 5);
        System.out.println(highCarbDietPlan.showPlan());
        System.out.println("Cost: " + highCarbDietPlan.getCost());

        System.out.println("======Conner Case Test========");

        System.out.println("--------Lunch and Dinner has the same recipe--------");
        DietPlan dietPlanTest = new VeganDietPlan("src/TestCase/lunch dinner test", 1);
        System.out.println(dietPlanTest.showPlan());
        System.out.println("Cost: " + dietPlanTest.getCost());


        System.out.println("--------Invalid day of week--------");
        DietPlan dietPlan = new VeganDietPlan("src/TestCase/vegan recipes", 9);
        System.out.println(dietPlan.showPlan());
        System.out.println("Cost: " + dietPlan.getCost());

        System.out.println("--------file not found--------");
        DietPlan dietPlan1 = new VeganDietPlan("src/TestCase/vegan-recipes", 2);
        System.out.println(dietPlan1.showPlan());
        System.out.println("Cost: " + dietPlan1.getCost());
        DietPlan dietPlan2 = new LowCarbDietPlan("low carb recipes", 3);
        System.out.println(dietPlan2.showPlan());
        System.out.println("Cost: " + dietPlan2.getCost());
    }

    /**
     * This is to test the class of DietPlanOrder,
     * and how it goes when making a payment with a type of credit card that is not accepted or invalid,
     * when card number cannot be verified based on the type of card selected,
     * and when recipe file name is not valid.
     *
     * @throws IOException
     */
    public void testDietPlanOrder() throws IOException {
        System.out.println("======Diet Plan Order Test========");
        DietPlanOrder d1 = new DietPlanOrder("Mary", "src/TestCase/vegan recipes", MealType.VEGAN);
        System.out.println("Cost: " + d1.getCost());
        System.out.println("------Visa Card------");
        System.out.println(d1.acceptPayment("Visa", "4320338314328345", d1.getCost()));
        d1.generateInvoice();
        System.out.println(d1.acceptPayment("Visa", "4320338314328", d1.getCost()));
        d1.generateInvoice();
        System.out.println("------Master Card------");
        System.out.println(d1.acceptPayment("MasterCard", "5234567890123456", d1.getCost()));
        d1.generateInvoice();

        DietPlanOrder d12 = new DietPlanOrder("Jones", "src/TestCase/low-carb recipes", MealType.LOWCARB);
        System.out.println("Cost: " + d12.getCost());
        System.out.println(d12.acceptPayment("Visa", "4320338314328345", d12.getCost()));
        d12.generateInvoice();

        System.out.println("======Corner Case Test======");
        System.out.println("------file not found------");
        DietPlanOrder d2 = new DietPlanOrder("Sue", "vegan-recipes", MealType.LOWCARB);
        System.out.println("Cost: " + d2.getCost());

        System.out.println("------payment info wrong------");
        System.out.println(d1.acceptPayment("Visa", "432033831432", d1.getCost()));
        d1.generateInvoice();
        System.out.println(d1.acceptPayment("MasterCard", "523456789012345", d1.getCost()));
        d1.generateInvoice();
        System.out.println(d1.acceptPayment("Mastercard", "5234567890123456", d1.getCost()));
        d1.generateInvoice();
        System.out.println(d1.acceptPayment("Discover", "4320338314328345", d1.getCost()));
        d1.generateInvoice();
    }
}

package com.project.recipes;

import com.project.data.DataLoader;
import java.util.ArrayList;
import java.util.List;

public class RecipeManager {
    private List<Recipe> recipes;
    private DataLoader dataLoader; // This field was not being set

    public RecipeManager(DataLoader dataLoader) {
        this.dataLoader = dataLoader; // Fix: Assign the passed DataLoader
        this.recipes = dataLoader.loadRecipes();
    }

    public List<Recipe> searchMaterials(String materialName) {
        List<Recipe> results = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getName().toLowerCase().contains(materialName.toLowerCase())) {
                results.add(recipe);
            }
        }
        return results;
    }

    public void listRecipes() {
        for (Recipe recipe : recipes) {
            System.out.println("══════════════════════");
            System.out.println("Receita: " + recipe.getName());
            System.out.println("Ingredientes: " + String.join(", ", recipe.getIngredients()));
            System.out.println("Biomas: " + String.join(", ", recipe.getBiomes()));
            System.out.println("Dica: " + recipe.getTip());
            System.out.println("══════════════════════");
        }
    }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    public Recipe getRecipeByName(String name) {
        return dataLoader.getRecipes().stream()
                .filter(recipe -> recipe.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
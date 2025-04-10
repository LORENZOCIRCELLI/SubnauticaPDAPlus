package org.recipes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.materials.Resources;

public class RecipeLoader {

    public static Map<String, Recipes> loadFromCsv (String pathCSV){

        Map<String, Recipes> map = new HashMap<>();

        pathCSV = "/home/lorenzo/IdeaProjects/SubnauticaPDAPlus/src/main/resources/data/recipes.csv";

        try(BufferedReader bufferedReader= new BufferedReader(new FileReader(pathCSV))){

            String line;
            while((line = bufferedReader.readLine()) != null){

                String[] split = line.split(",", -1);

                if(split.length < 5){continue;}

                String name = split[0];
                RecipeCategory recipeCategory = RecipeCategory.valueOf(split[1]);
                String resourceStr = split[2].trim();
                String description =  split[3];
                String note = split[4];

                Map<Resources, Integer> resourcesMap = new HashMap<>();

                if(!resourceStr.isEmpty()){

                    String [] ingredientsParts = resourceStr.split(";");
                    for(String ingredient : ingredientsParts){

                        String[] keyval = ingredient.split(":");
                        if(keyval.length == 2){

                            Resources resources = Resources.valueOf(keyval[0]);
                            int amount = Integer.parseInt(keyval[1]);
                            resourcesMap.put(resources, amount);

                        }

                    }

                }
                Recipes recipe = new Recipes(name, recipeCategory, resourcesMap, description, note);
                map.put(name, recipe);


            }

        }
        catch(IOException e){

            System.out.println("Error reading file");

        }

    return map;
    }

}

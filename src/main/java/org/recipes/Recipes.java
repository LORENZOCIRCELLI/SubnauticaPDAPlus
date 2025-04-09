package org.recipes;
import org.materials.Resources;

import java.util.Map;

public class Recipes {

    String name;
    RecipeCategory category;
    Map<Resources, Integer> resources;
    String description;
    String note;

    public Recipes(String name, RecipeCategory category, Map<Resources, Integer> resources, String description, String note) {

        this.name = name;
        this.category = category;
        this.resources = resources;
        this.description = description;
        this.note = note;

    }

    public static void procurar(String name){



    }

}

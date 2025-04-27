package org.functions;

import org.db.DB;
import org.recipes.RecipeLoader;

import java.util.ArrayList;
import java.util.List;

public class Functions {

    RecipeLoader ld = new RecipeLoader();
    List<String> raw_materials = ld.recipeLoader();

    public void search_Materials(String material){

        for(String mt : raw_materials){

            if (material.equals(mt)) {
                System.out.println("Found the material: " +material);
            }

        }

    }

    public void list_materials(){

       for(String mt : raw_materials){

           System.out.println(mt);

       }

    }

    public void add_material(String material){

        ld.addRecipe(material);

    }

    public void remove_material(String material){

        int controller = -1;

        for(String mt : raw_materials){

            if(material.equals(mt)){

                ld.removeRecipe(material);
                controller = 1;

            }

        }
        if(controller == 1){

            System.out.println("Removed the material: " +material);

        }
        else{

            System.out.println("The material is not present in the database");

        }


    }


}

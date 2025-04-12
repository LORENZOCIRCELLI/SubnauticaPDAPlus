package org.main;

import org.db.DB;
import org.materials.*;
import org.recipes.*;

import java.sql.Connection;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Connection connection = DB.getConnection();
        DB.closeConnection();

        boolean status = true;
        int option;

        Map<String, Recipes> allRecipes = RecipeLoader.loadFromCsv("resources/data/recipes.csv");

        Scanner input = new Scanner(System.in);

        System.out.println("""
                     ____  _   _ ____  _   _    _   _   _ _____ ___ ____    _    
                    / ___|| | | | __ )| \\ | |  / \\ | | | |_   _|_ _/ ___|  / \\   
                    \\___ \\| | | |  _ \\|  \\| | / _ \\| | | | | |  | | |     / _ \\  
                     ___) | |_| | |_) | |\\  |/ ___ \\ |_| | | |  | | |___ / ___ \\ 
                    |____/ \\___/|____/|_| \\_/_/   \\_\\___/  |_| |___\\____/_/   \\_\\
                     ____  ____    _                                             
                    |  _ \\|  _ \\  / \\       _     _                              
                    | |_) | | | |/ _ \\    _| |_ _| |_                            
                    |  __/| |_| / ___ \\  |_   _|_   _|                           
                    |_|   |____/_/   \\_\\   |_|   |_|                             
                                                                                    
                           """);

        while(status){

            String answer;

            System.out.println("1 - Pesquisar por Receita");
            System.out.println("2 - Listar as Receitas");
            System.out.println("3 - Gerador de Bases");
            System.out.println("9 - Sair");

            option = input.nextInt();

            switch(option){

                case 1:

                    System.out.println("Insira a receita que deseja procurar: ");
                    input.nextLine();
                    answer = input.nextLine().toUpperCase();

                    for(Recipes recipe :  allRecipes.values()){

                        if(recipe.getName().toUpperCase().equals(answer)){

                            System.out.println("Recipe: ");
                            System.out.println(recipe.getName());
                            System.out.println(recipe.getDescription());
                            for(var entry : recipe.getResources().entrySet()){

                                System.out.println(entry.getKey() + ": " + entry.getValue());

                            }
                            System.out.println(recipe.getNote());

                        }

                    }

                    System.out.println();

                    break;

                case 2:

                    for(Recipes recipe : allRecipes.values()){

                        System.out.println("\nName: " +recipe.getName());
                        System.out.println("Category: " +recipe.getCategory());
                        for(var entry : recipe.getResources().entrySet()){

                            System.out.println("Resource: " +entry.getKey() +  " - " + entry.getValue());

                        }
                        System.out.println("Description " +recipe.getDescription());
                        System.out.println("Note:  " +recipe.getNote());

                    }

                    break;

                case 3:

                    System.out.println("Build a project:");

                    System.out.println("\n\n1 - By Area");
                    System.out.println("2 - By Advancement");
                    System.out.println("3 - By size");
                    System.out.println("4 - Developer Choice");

                    int answ2 = input.nextInt();
                    switch(answ2){

                        case 1:

                            System.out.println("1 - Kelp Forest");
                            System.out.println("2 - Grassy Plateaus");
                            System.out.println("3 - Mushroom Forest (Next to Lost River Entrance");
                            System.out.println("4 - Bubble Zone (Below Floating Island)");
                            System.out.println("5 - Lost River");
                            System.out.println("6 - Inactive Lava Zone");
                            System.out.println("9 - Sair");

                            int answ3 = input.nextInt();

                            switch(answ3){

                                case 1:



                            }

                            break;

                        case 2:
                            System.out.println("1 - Early Game (Basic Areas, next to the surface)");
                            System.out.println("2 - Mid Game (Medium Areas, between 300m and 900m");
                            System.out.println("3 - Late Game (Advanced Areas, unlocked Lava Zones");
                            System.out.println("4 - End Game (Reached every resource needed)");

                            answ3 = input.nextInt();

                            break;

                    }

                    break;

                case 9:
                    System.out.println("Deseja continuar? (S/N)");
                    char ans =  input.next().charAt(0);

                    if(ans =='N' ||  ans =='n'){

                        status = false;

                    }


            }

        }

    }
}
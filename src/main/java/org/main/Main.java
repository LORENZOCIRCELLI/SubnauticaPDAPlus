package org.main;

import org.materials.*;
import org.recipes.*;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean status = true;
        int option;

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

            System.out.println("\n\n1 - Pesquisar por Receita");
            System.out.println("2 - Listar as Receitas");
            System.out.println("9 - Sair");

            option = input.nextInt();

            switch(option){

                case 1:

                    System.out.println("Insira a receita que deseja procurar: ");
                    input.nextLine();
                    answer = input.nextLine();

                    System.out.println();

                    break;

                case 2:

                    Map<String, Recipes> allRecipes = RecipeLoader.loadFromCsv("resources/data/recipes.csv");

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
package org.main;

import org.db.DB;
import org.functions.Functions;
import org.materials.*;
import org.recipes.*;

import java.sql.Connection;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean status = true;
        int option;

        Functions fs = new Functions();

        Scanner input = new Scanner(System.in);

        System.out.println("""
                     ____  _   _ ____  _   _    _   _   _ _____ ___ ____    _    
                    / ___|| | | | __ )| \\ | |  / \\ | | | |_   _|_ _/ ___|  / \\   
                    \\___ \\| | | |  _ \\|  \\| | / _ \\| | | | | |  | | |     / _ \\  
                     ___) | |_| | |_) | |\\  |/ ___ \\ |_| | | |  | | |___ / ___ \\ 1
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

                    System.out.println("Insira o nome do material que deseja pesquisar: ");
                    String name = input.next();
                    fs.search_Materials(name);

                    break;

                case 2:

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



                case 4:

                    fs.add_material("Amethyst");

                    break;

                case 5:
                    fs.remove_material("Amethyst");

                    break;





                case 9:
                    System.out.println("Deseja continuar? (S/N)");
                    char ans =  input.next().charAt(0);

                    if(ans =='N' ||  ans =='n'){

                        DB db = new DB();
                        db.closeConnection();

                        status = false;

                    }


            }

        }

    }
}